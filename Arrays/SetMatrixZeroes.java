public class SetMatrixZeroes {
    static void set_matrix_zeros3(int nums[][],int n)
    {
        //optimal
        int col0 = 1;
        for(int i=0;i<n;i++)  
        {  
            for(int j=0;j<n;j++)  
            {
                if(nums[i][j] == 0)
                {
                    //mark the i-th row 
                    //mark the j-th column
                    nums[i][0] = 0;
                    if(j != 0)
                    {
                        nums[0][j] = 0;
                    }
                    else{
                        col0 =0;
                    }
                   

                }
            }
        }
        for(int i=1;i<n;i++)  {
            for(int j=1;j<n;j++)  
            {
                if(nums[i][j] != 0)
                {
                    //check for column and row
                    if(nums[0][j] ==0|| nums[i][0]  == 0) 
                    {
                        nums[i][j] = 0;
                    }
                }
            }
        }
        if(nums[0][0] == 0)
        {
            for(int j=0;j<n;j++)   
            {
                nums[0][j] = 0;
            }
        }
        if(col0 == 0)
        {
            for(int i=0;i<n;i++)    
            {
                nums[i][0] = 0;
            }
        }
    }
    void display(int nums[][],int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String s[]){
        SetMatrixZeroes m1 = new SetMatrixZeroes();
        int[][] matrix = {{1,1,1,1},{1,0,0,1},{1,0,1,0},{1,1,0,1}};
        m1.display(matrix, matrix.length);
        set_matrix_zeros3(matrix, matrix.length);
        System.out.println("Answer...:");
        m1.display(matrix, matrix.length);
    }
}
