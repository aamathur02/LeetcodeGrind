package Sorting_Algorithms.BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println((recursiveBinarySearch(array, 7, 0, array.length - 1)));

    }

    public static int iterativeBinarySearch(int[] array, int target) {
        int first = 0;
        int last = array.length - 1;
        int mid;
        while (first <= last) {
            mid = first + (last - first) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                first = mid + 1;
            }

            else {
                last = mid - 1;
            }
        }

        return -1;
    }

    public static int recursiveBinarySearch(int[] array, int target, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (array[mid] > target) 
                return recursiveBinarySearch(array, target, low, mid -1); 
  
            // Else the element can only be present 
            // in right subarray 
            return recursiveBinarySearch(array, target, mid + 1, high); 
        }

        return -1;
        
    }
}