
import java.util.Scanner;

public class MoveZeroes {

    static void moveZeroes(int arr[], int n) {
        int temp[] = new int[n];
        int index = 0;
        //brute force solution
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[index++] = arr[i];
            }
        }
        for(int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];  //stores all non-negative numbers
        }
        for (int i = temp.length; i < n; i++) {
            arr[i] = 0;
        }
    }

    static void moveZeroes2(int arr[], int n) {
        //optimal solution
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
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
        //moveZeroes(arr, n);
        moveZeroes2(arr, n);
        displayArray(arr, n);

    }
}
