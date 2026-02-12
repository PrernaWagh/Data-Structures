
import java.util.HashSet;


public class UnionArray {

    int hashFunction(int key, int size) {
        return key % size;
    }

    void insert(int hashTable[], int key, int size) {
        int index = hashFunction(key, size);

        // Linear probing
        while (hashTable[index] != -1) {
            if (hashTable[index] == key) {
                return;   // Duplicate found

                        }index = (index + 1) % size;
        }

        hashTable[index] = key;
    }

    void union_array(int arr1[], int n, int arr2[], int m) {
        int size = n + m;
        int hashTable[] = new int[n + m];
        int index = 0;
        //copy elements of first array into hashArr
        // Initialize with -1 (means empty)
        for (int i = 0; i < size; i++) {
            hashTable[i] = -1;
        }

        // Insert arr1 elements
        for (int i = 0; i < arr1.length; i++) {
            insert(hashTable, arr1[i], size);
        }

        // Insert arr2 elements
        for (int i = 0; i < arr2.length; i++) {
            insert(hashTable, arr2[i], size);
        }

        for (int i = 0; i < size; i++) {
            if (hashTable[i] != -1) {
                System.out.print(hashTable[i] + " ");
            }
        }
    }

    void union_array2(int arr1[],int n,int arr2[],int m) 
    {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(arr1[i]);
        }
        for(int j=0;j<m;j++)
        {
            set.add(arr2[j]);
        }
        for(int e:set)  {
            System.out.print(e+" ");
        }
    }
    public static void main(String s[]) {
        UnionArray obj1 = new UnionArray();
        int arr1[] = {1, 1, 2, 3, 4, 5};
        int arr2[] = {2, 3, 4, 4, 5, 6};

        // obj1.union_array(arr1, arr1.length, arr2, arr2.length);
        obj1.union_array2(arr1, arr1.length, arr2, arr2.length);
    }
}
