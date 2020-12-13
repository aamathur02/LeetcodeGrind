package Easy.Arrays;

public class Solution {


    /**
     * 
     * @param nums array to be acted upon
     * @return number of unique elements in array
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }
    
}
