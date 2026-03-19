//program for printing pascal triangle

//1.Display element at given place row,col;
//2.Generate nth row of pascal triangle
//3.Display entire pascal triangle

import java.util.ArrayList;
import java.util.List;
public class PascalTriangle{
    long ncr(int n,int r)
    {
        //1st problem solution
        long result = 1;
        for(int i=0;i<r;i++)
        {
            result = result*(n-i);
            result = result/ (i+1);
        }
        return result;
    }
    List<Integer> generateRow(int row)
    {
        //2nd problem solution
        List<Integer> temp = new ArrayList<>();
        int ans = 1;
        temp.add(1);
        for(int i=1;i<row;i++)
        {
            ans = ans*(row-i);
            ans = ans/i;
            temp.add(ans);
        }
        return temp;
    }
    List<List<Integer>> pascal_triangle2(int n)
    {
        //3rd problem solution
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            List<Integer> temp = generateRow(i);
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String s[])
    {
        PascalTriangle p1 = new PascalTriangle();
        System.out.println("Element at row = 3 and col = 2 is :"+p1.ncr(3,2));
       
        List<Integer> ans = p1.generateRow(6);
        System.out.println("6th row is : "+ans);

        List<List<Integer>> output = p1.pascal_triangle2(6);
        System.out.print(output);
    }
}

//output:
// Element at row = 3 and col = 2 is :3
// 6th row is : [1, 5, 10, 10, 5, 1]
// [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1]]