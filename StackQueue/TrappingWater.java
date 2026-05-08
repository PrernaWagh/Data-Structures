// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


class TrappingWater {
    public int trap(int[] height) {
        int lMax = 0;
        int rMax = 0;
        int total = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r)
        {
            if(height[l] <= height[r])
            {
                if(lMax > height[l])
                {
                    total += lMax - height[l];
                }
                else{
                    lMax = height[l];
                }
                l++;
            }
            else{
                if(rMax > height[r])
                {
                    total += rMax - height[r];
                }
                else{
                    rMax = height[r]; 
                }
                r--;
            }
        }
        return total;
    }
}