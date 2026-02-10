
import java.util.Scanner;

public class RotateArrayLeft {

    static void displayArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.err.println();
    }

    static void rotateArray(int arr[], int n, int d) {
        //brute force approach for rotating array by d places- left roate
        int temp[] = new int[d];
        for(int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        displayArray(temp, d);
        //shifting
        for(int i=d;i<n;i++){
            arr[i-d] = arr[i];
        }
        //place temp elements into array
        for(int i=n-d;i<n;i++)
        {
            arr[i] = temp[i-(n-d)];
        }
    }
    static void reverse(int arr[],int start,int end)
    {
        while(start <= end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    static void rotateArray3(int arr[],int n,int d)
    {
        reverse(arr, 0,d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);

    }
    
    public static void main(String s[]) {
        int n;
        System.out.println("Enter size for an array : ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
         rotateArray(arr, n);
        displayArray(arr, n);
    }
}
