public class FirstLastOccurence {
    int findFirstOccurence(int arr[],int n,int x)
    {
        int low = 0;
        int mid = 0;
        int high = n -1;
        int first = -1;
        while(low <= high)
        {
            mid = (low + high) / 2;
            if(arr[mid] == x)
            {
                first = mid;
                high = mid - 1;
            }
            else if (arr[mid ] < x)
            {
                low = mid + 1;
            }
            else{
                high = mid -1;
            }
        }
        return first;
    }
     int findLastOccurence(int arr[],int n,int x)
    {
        int low = 0;
        int mid = 0;
        int high = n -1;
        int last = -1;
        while(low <= high)
        {
            mid = (low + high) / 2;
            if(arr[mid] == x)
            {
                last = mid;
               low = mid + 1;
            }
            else if(arr[mid] > x)
            {
                high = mid -1 ;
            }
            else{
                low = mid + 1;
            }
        }
        return last;
    }
    int[] findFirstLast(int arr[],int n,int x)
    {
        int first = findFirstOccurence(arr, n, x);
        if(first == -1) return new int[]{-1, -1};
        int last = findLastOccurence(arr, n, x);
        return new int[]{first, last};

    }
    public static void main(String s[])
    {
        FirstLastOccurence f1 = new FirstLastOccurence();
        int arr[] = {1,2,4,6,8,8,8,9,10};
        int result[] = f1.findFirstLast(arr, arr.length, 8);
        for(int e:result)
        {
            System.out.println(e);
        }

    }
}
