import java.util.Scanner;
public class FindSquareRoot {
    public void findSquareRoot(int n)
    {
        int low = 1;
        int high = n;
        int ans = 1;
        int mid = 0;
        while(low <= high)
        {
            mid = (low + high)/2;
            if(mid*mid <= n)
            {
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        System.out.println("Square root of "+n+" is "+ans);
    }
    public static void main(String s[])
    {
        int n = 0;
        FindSquareRoot f1 = new FindSquareRoot();
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.println("Enter a number : ");
            n = sc.nextInt();
            if(n < 0)
            {
                System.out.println("Negative numbers are not having square root");
                continue;
            }
            else if (n == 0)
            {
                System.out.println("Square root of zero is zero");
                break;
            }
            else{
                f1.findSquareRoot(n);
                break;
            }
        } while (true);

       
    }
}