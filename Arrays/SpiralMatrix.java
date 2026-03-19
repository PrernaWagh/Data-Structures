import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }

        }
        return ans;
    }
    public static void main(String s[])
    {
        int[][] matrix= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }
}