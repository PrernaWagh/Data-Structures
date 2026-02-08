
public class ArraySorted {

    boolean checkArraySorted(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {  //if array list is there use arr.get(i)  

            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String s[]) {
        int arr[] = {1,2,3,3,4,5,6};
        ArraySorted a1 = new ArraySorted();
        int n = arr.length;
        if(a1.checkArraySorted(arr, n))
        {
            System.out.println("Array is sorted");
        }
        else{
            System.out.println("Array is not sorted");
        }
    }
}
