import java.util.*;

public class Blind75 {
    
    public int[] twoSumBF(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int complent = target - nums[i];

            for (int j = i+1; j < nums.length; j++) {
                
                if (nums[j] ==  complent) {
                    return new int[]{i,j};
                }
                
            }
        }

        return null;
    }

    public int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complent = target - nums[i];

            if (map.containsKey(complent)) {
                return new int[]{i, map.get(complent)};
            } 

            map.put(nums[i], i);
        }

        return null;
    }

    public int lengthOfLongestSubstringBF(String s) {

        //edge case where string length is zero
        if (s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

    }

    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return s;
        }

        String palindrome = "";
        int length = s.length();
        int maxLength = 0;

        boolean[][] dpTable = new boolean[length][length];

        for (int j = 0; j < length; j++) {

            for (int i = 0; i <= j; i++) {
                boolean match = s.charAt(i) == s.charAt(j);

                if (j - i > 2) {
                    dpTable[i][j] = dpTable[i + 1][j - 1] && match;
                } else {
                    dpTable[i][j] = match;
                }

                if (dpTable[i][j] && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    palindrome = s.substring(i, j + 1);
                }
            }
        }

        return palindrome;
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area = 0;

        while (left < right) {
            area = Math.max(area,Math.min(height[left], height[right]) * (right - left));

            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }

        }

        return area;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;


            while (j < k) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (k != nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return results;


    }



}
