
//Problem:- Count the number of subarrays having sum equal to k
//Map is used to store the key value pairs key is the value in array and Arraylist is used to store 
//indexes of subarray values
import java.util.ArrayList;
import java.util.HashMap;

public class CountSubarray {

    static int subArraySum(int arr[], int n, int k) //TC - O(N)  //SC- O(N)
    {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int sum = 0;
        int cnt = 0;
        // Base case
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.containsKey(sum - k)) {
                ArrayList<Integer> list = map.get(sum - k);

                for (int startIndex : list) {
                    // Print subarray
                    System.out.print("Subarray: ");
                    for (int j = startIndex + 1; j <= i; j++) {
                        System.out.print(arr[j] + " ");
                        
                    }
                    System.out.println();
                    cnt ++;
                }
                
            }

            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return cnt;
    }

    public static void main(String s[]) {
        int arr[] = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        System.out.println(subArraySum(arr, arr.length, 3));
        
    }

}
