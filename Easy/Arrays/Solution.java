package Easy.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);

        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num: nums) {
            a ^= num;
        }

        return a;
    }

    public int[] intersectionOfTwoArrays(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num: nums1) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int num: nums2) {
            int count = map.getOrDefault(num, 0);
            if (count >  0) {
                count--;
                map.put(num, count);
                list.add(num);
            }
        }

        int[] returnArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            returnArray[i] = list.get(i);
        }

        return returnArray;

    }

    public int[] plusOne(int[] nums) {
        for (int i = nums.length -1; i >= 0; i--) {
            if (nums[i] < 9) {
                nums[i]++;
                return nums;
            }

            nums[i] = 0;
        }

        int[] returnArray = new int[nums.length + 1];
        returnArray[0] = 1;
        return returnArray;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("Invalid Input String");
    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> [] rows = new HashSet[9];
        HashSet<Character> [] columns = new HashSet[9];
        HashSet<Character> [] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            columns[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();            
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int boxIndex = (i / 3) * 3 + j / 3;

                    if (!rows[i].add(num) || !columns[j].add(num) || !boxes[boxIndex].add(num)) {
                        return false;
                    }

                }
            }
        }

        return true;
    }


    
}
