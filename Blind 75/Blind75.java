import java.util.Map;

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

    
}
