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

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (n == 1 && head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            if (map.containsKey(currChar)) {
                stack.push(currChar);
            } else {
                if (stack.isEmpty()) return false;
                Character poppedChar = stack.peek();
                if (map.get(poppedChar).equals(currChar)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        } else if (node2 == null) {
            return node1;
        } else if (node1 == null) {
            return node2;
        }
        ListNode one = node1;
        ListNode two = node2;

        ListNode dummy = new ListNode(-1);
        ListNode curr = new ListNode(-1);
        dummy.next = curr;

        while (one != null && two != null) {
            if (one.val > two.val) {
                curr.next = two;
                two = two.next;
            } else {
                curr.next = one;
                one = one.next;
            }

            curr = curr.next;
        }

        while (one != null) {
            curr.next = one;
            one = one.next;
            curr = curr.next;
        }

        while (two != null) {
            curr.next = two;
            two = two.next;
            curr = curr.next;
        }

        return dummy.next.next;

    }



}
