public class FloodFill {
    private void dfs(int sr,int sc,int[][] ans,int[][] image,int newColor,int[] delRow,int[] delCol,int inicolor)
    {
        ans[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;

        for(int i=0;i<4;i++)
        {
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];
            if(nrow >=0 && nrow < n && ncol >=0 && ncol<m && image[nrow][ncol] == inicolor &&
            ans[nrow][ncol] != newColor)
            {
                dfs(nrow,ncol,ans,image,newColor,delRow,delCol,inicolor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor = image[sr][sc];
        int ans[][] = image;
        int delRow[] = {-1,0,+1,0};
        int delCol[] = {0,-1,0,+1};
        dfs(sr,sc,ans,image,color,delRow,delCol,inicolor);

        return ans; 
    }
}