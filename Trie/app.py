# ============================================
# PROTOTYPE - MVP CODE
# PS9: Wavefront Reconstruction
# ============================================

import numpy as np
import matplotlib.pyplot as plt
import cv2
from scipy.ndimage import center_of_mass
from scipy.linalg import lstsq
from scipy.special import eval_jacobi

class SHWFSPrototype:
    def __init__(self):
        self.lenslet_pitch = 10  # pixels
        self.n_lenslets = 10
        self.pixel_pitch = 5.5e-6  # meters
        self.lenslet_focal = 3.7e-3  # meters
        
    def load_frame(self, filepath):
        """Load BMP frame"""
        img = cv2.imread(filepath, cv2.IMREAD_GRAYSCALE)
        return img.astype(np.float32)
    
    def detect_spots(self, image):
        """Find spots and compute centroids"""
        height, width = image.shape
        step = self.lenslet_pitch
        centroids = []
        
        for i in range(0, height - step, step):
            for j in range(0, width - step, step):
                subwindow = image[i:i+step, j:j+step]
                if subwindow.max() > 50:  # threshold
                    # Center of Mass
                    total = subwindow.sum()
                    if total > 0:
                        x = np.sum(np.arange(step) * subwindow.sum(axis=0)) / total
                        y = np.sum(np.arange(step) * subwindow.sum(axis=1)) / total
                        centroids.append([j + x, i + y])
                    else:
                        centroids.append([np.nan, np.nan])
                else:
                    centroids.append([np.nan, np.nan])
        
        return np.array(centroids).reshape(self.n_lenslets, self.n_lenslets, 2)
    
    def compute_slopes(self, centroids, reference):
        """Convert centroids to slopes"""
        displacement = centroids - reference
        slopes = displacement * (self.pixel_pitch / self.lenslet_focal)
        return slopes
    
    def reconstruct_phase(self, slopes):
        """Zernike reconstruction (simplified)"""
        # Simple integration (placeholder)
        sx = slopes[:, :, 0]
        sy = slopes[:, :, 1]
        
        # 2D integration using cumulative sum
        phase = np.zeros_like(sx)
        for i in range(1, sx.shape[0]):
            phase[i, :] = phase[i-1, :] + sy[i, :] * self.lenslet_pitch
        for j in range(1, sy.shape[1]):
            phase[:, j] = phase[:, j-1] + sx[:, j] * self.lenslet_pitch
        
        return phase
    
    def estimate_r0(self, phase):
        """Estimate Fried parameter"""
        var = np.var(phase[phase != 0])
        D = self.n_lenslets * self.lenslet_pitch * self.pixel_pitch
        r0 = D / (var / 0.134) ** (3/5)
        return r0
    
    def compute_actuator_map(self, phase):
        """Generate actuator commands"""
        # Simplified: negative of phase at actuator positions
        actuator_map = -phase[::2, ::2]  # Fried geometry
        return actuator_map
    
    def visualize_pipeline(self, image, centroids, slopes, phase, actuator):
        """Create dashboard-style visualization"""
        fig, axes = plt.subplots(2, 3, figsize=(15, 10))
        
        # Raw image
        axes[0, 0].imshow(image, cmap='gray')
        axes[0, 0].set_title('Raw Spots')
        
        # Centroids
        axes[0, 1].imshow(image, cmap='gray')
        axes[0, 1].scatter(centroids[:, :, 0].flatten(), 
                          centroids[:, :, 1].flatten(), 
                          c='red', s=5)
        axes[0, 1].set_title('Centroids')
        
        # Slopes
        axes[0, 2].imshow(slopes[:, :, 0], cmap='RdBu')
        axes[0, 2].set_title('Slope X')
        
        # Phase map
        axes[1, 0].imshow(phase, cmap='RdBu')
        axes[1, 0].set_title('Reconstructed Phase')
        
        # Actuator map
        axes[1, 1].imshow(actuator, cmap='RdBu')
        axes[1, 1].set_title('Actuator Map')
        
        # Turbulence
        r0 = self.estimate_r0(phase)
        axes[1, 2].text(0.1, 0.5, f'r₀ = {r0*100:.2f} cm', fontsize=16)
        axes[1, 2].axis('off')
        axes[1, 2].set_title('Turbulence Parameters')
        
        plt.tight_layout()
        plt.savefig('screenshots/08_dashboard_full.png', dpi=150)
        return fig

# ============================================
# USAGE
# ============================================

if __name__ == "__main__":
    # Initialize
    wfs = SHWFSPrototype()
    
    # Load data
    image = wfs.load_frame('data/raw/frame_001.bmp')
    
    # Process
    centroids = wfs.detect_spots(image)
    # Reference centroids (from calibration)
    reference = np.ones_like(centroids) * 4.5  # placeholder
    
    slopes = wfs.compute_slopes(centroids, reference)
    phase = wfs.reconstruct_phase(slopes)
    actuator = wfs.compute_actuator_map(phase)
    
    # Visualize
    wfs.visualize_pipeline(image, centroids, slopes, phase, actuator)