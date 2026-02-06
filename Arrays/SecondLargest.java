import java.util.Scanner;
public class SecondLargest {

    static int findSecondLarge(int arr[], int n) {
        //better solution for finding second largest element O(2N)
        int max = arr[0];
        int secondMax = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    static int findSL(int arr[], int n) {
        //optimal solution for finding second large element O(N)
        int large = arr[0];
        int s_large = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > large) {
                s_large = large;
                large = arr[i];
            } else if (arr[i] < large && arr[i] > s_large) {
                s_large = arr[i];
            }
        }
        return s_large;
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
        System.out.println("Second largest element is : " + findSecondLarge(arr, n));
        System.out.println("Second large element is : "+findSL(arr, n));
    }

}
