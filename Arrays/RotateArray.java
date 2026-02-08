
import java.util.Scanner;

public class RotateArray {

    static void rotateArray(int arr[], int n) {
        //rotate array by one place - left rotate 
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }

    static void displayArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.err.println();
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
