
import java.util.*;

public class ThreeSum {
    //quick sort for sorting
    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i] <= pivot && i <= high-1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            
        }
        //place pivot at its correct position
            int temp = arr[low];
            arr[low] = arr[j];
            arr[j] = temp;

        return j;
    }

    static void quick_sort(int arr[], int low, int high) {
        if (low < high) {
            int p_index = partition(arr, low, high);
            quick_sort(arr, low, p_index - 1);
            quick_sort(arr, p_index+1, high);
        }
    }
    static List<List<Integer>> three_sum(int nums[]) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        //sort array
        quick_sort(nums, 0, n-1);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j< k &&  nums[k] == nums[k-1]) k--;
                }
            }
        }
        return ans;
    }
    public static List<List<Integer>> triplet(int n, int[] num) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int third = -(num[i] + num[j]);

                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(num[i], num[j], third);
                    Collections.sort(temp);   // ensure uniqueness
                    set.add(temp);
                }

                hashSet.add(num[j]);
            }
        }

        // Convert set to list
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        int nums[] = {-2,-2,-2,-1,-1,-1,0,0,0,2,2,2,2};
        List<List<Integer>> output = triplet(nums.length, nums);
        System.out.println(output);
    }
}
