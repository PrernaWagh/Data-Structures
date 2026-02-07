
import java.util.*;

public class RemoveDuplicates {
    static int removeDuplicates(int arr[], int n) {
        //optimal solution-> TC->O(N)   SC->O(1)
        int i=0;
        for(int j =1;j<n;j++)
        {
            if(arr[j] !=arr[i])
            {
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }
    static int removeDuplicates2(int arr[],int n)
    {
        //brute-force method O(N)  SC->O(N)
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(arr[i]);
        }
        int index=0;
        for(int e :set){
            arr[index++] =e;
        }
        return index;
    }


    static void displayArray(int arr[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i] + " ");
        }
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
        int index = removeDuplicates2(arr, n);
        System.out.println(index);
        displayArray(arr, index);
    }
}
