//search the element in rotated sorted array and return index of it otherwise -1
public class SearchInRotatedSoretedArr {
    int search(int arr[],int n,int target)
    {
        int low = 0;
        int high = 0;
        int mid = 0;
        high = n-1;

        while(low <= high) 
        {
            mid = (low + high) / 2;
            if(arr[mid] == target)
            {
                return mid;
            }
            if(arr[low] == arr[mid] && arr[mid] == arr[high])
            {
                //shrink search space for handling duplicates
                low = low + 1;
                high = high -1 ;
                continue;
            }
            if(arr[low] <= arr[mid])
            {
                if(arr[low] <= target && target <= arr[mid])
                {
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(arr[mid] <= target && target <= arr[high])
                {
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String s[])
    {
        SearchInRotatedSoretedArr s1 = new SearchInRotatedSoretedArr();
        int arr[] = {7,8,9,1,2,3,4,5,6};
        int index = s1.search(arr, arr.length, 1);
        System.out.println("Searched element present at : "+index);

    }
}
