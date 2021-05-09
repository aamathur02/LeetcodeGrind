import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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


}
