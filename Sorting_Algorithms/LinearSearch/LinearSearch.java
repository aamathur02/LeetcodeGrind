package Sorting_Algorithms.LinearSearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] testArray = {1,2,3,4,5,6,7,8,9};
        System.out.println(linearSearch(testArray, 3));
    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    } 
}
