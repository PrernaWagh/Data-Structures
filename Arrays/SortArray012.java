public class SortArray012
{
	void sort(int arr[],int n)
	{
		int low=0;
        	int high = n-1;
        	int mid =0;
        	int temp=0;
        	while(mid <= high)
        	{
            		if(arr[mid] == 0)
            		{
                		temp= arr[mid];
                		arr[mid] = arr[low];
                		arr[low] = temp;
                		low++;
                		mid++;
            		}
            		else if(arr[mid] == 1)
            		{
                		mid++;
            		}
            		else{
                		temp = arr[mid];
                		arr[mid] = arr[high];
                		arr[high] = temp;
                		high--;
        	}
        }
	
}