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

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += (prices[i] - prices[i-1]) > 0 ? prices[i] - prices[i-1] : 0;
        }

        return profit;
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverseforRotate(nums, 0, nums.length - 1);
        reverseforRotate(nums, 0, k -1);
        reverseforRotate(nums, k, nums.length - 1);

    }

        public static void reverseforRotate(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;

                start++;
                end--;
            }

        }


    
}
