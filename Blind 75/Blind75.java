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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            if (curr.next != null) {
                queue.add(curr.next);
            }
            dummy.next = curr;
            dummy = dummy.next;


        }

        return head.next;
    }

    public static int search (int[] nums, int target) {
        int beginning = 0;
        int end = nums.length - 1;

        while (beginning <= end) {
            int mid = beginning + ((end - beginning) / 2);

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[beginning] == target) {
                return beginning;
            }

            if (nums[end] == target) {
                return end;
            }

            if (Math.abs(end - beginning) <= 1) {
                return -1;
            }


            //indicates that the lowest value is in the right
            if (nums[mid] > nums[end]) {
                //target value is in right side
                if (target > nums[mid] || target < nums[end]) {
                    beginning = mid + 1;
                } else { //target value in in left side
                    end = mid - 1;
                }
            }

            //indicates that the lowest value is in the left
            else if (nums[mid] < nums[beginning]) {
                //target value is in left side
                if (target > nums[beginning] || target < nums[mid]) {
                    end = mid - 1;
                } else { // target value is in right side
                    beginning = mid + 1;
                }
            }

            else if (target < nums[mid]) {
                end = mid - 1;
            }

            else if (target > nums[mid]) {
                beginning = mid + 1;
            }

        }

        return -1;
    }

    public List<List<Integer>> combinationSumBF(int[] candidates, int target) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        for (int i: candidates) {
            set.add(i);
        }

        for (int i: candidates) {
            if (i > target) {
                continue;
            }

            int modVal = target % i;
            if (modVal == 0) {
                int multiple = target / i;
                List<Integer> evenList = new ArrayList<>();
                for (int j = 0; j < multiple; j++) {
                    evenList.add(i);
                }

                list.add(evenList);
            } else {
                int indexMultiple = i;
                while (indexMultiple <= target) {
                    int mod = target % indexMultiple;
                    if (set.contains(mod)) {
                        List<Integer> oddList = new ArrayList<>();
                        oddList.add(mod);
                        int multiplier = (target - mod) / indexMultiple;
                        multiplier *= (indexMultiple / i);
                        for (int k = 0; k < multiplier; k++) {
                            oddList.add(i);
                        }

                        list.add(oddList);
                        continue;
                    }

                    indexMultiple += indexMultiple;
                }
            }


        }

        return list;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        sumHelper(candidates, resultList, list, target, 0);
        return resultList;
    }

    private void sumHelper(int[] candidates, List<List<Integer>> resultList, List<Integer> list, int target, int index) {
        if (target == 0) {
            resultList.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                sumHelper(candidates, resultList, list, target - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String value = String.valueOf(c);

            if (!map.containsKey(value)) {
                map.put(value, new ArrayList<>());
            }

            map.get(value).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public int maxSubArray(int[] nums) {
        int currentStreak = nums[0];
        int maxStreak = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentStreak = Math.max(nums[i], currentStreak + nums[i]);
            
            maxStreak = currentStreak > maxStreak ? currentStreak : maxStreak;
        }
        
        return maxStreak;
    }

    public boolean jumpGame(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        return lastPos == 0;
    }

    public int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();

        for (int[] i : intervals) {
            if (list.isEmpty() || i[0] > list.getLast()[1]) {
                list.add(i);
            } else if (i[0] <= list.getLast()[1]) {
                list.getLast()[1] = Math.max(list.getLast()[1], i[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] returnArray = new int[1][];
            returnArray[0] = newInterval;
            return returnArray;
        }

        LinkedList<int[]> list = new LinkedList<int[]>();
        int pointer = 0;

        while (pointer < intervals.length && intervals[pointer][1] < newInterval[0]) {
            list.add(intervals[pointer]);
            pointer++;
        }

        int minValue = (pointer < intervals.length) ? Math.min(newInterval[0], intervals[pointer][0]) : newInterval[0];
        int maxValue = newInterval[1];

        while (pointer < intervals.length && intervals[pointer][0] <= newInterval[1]) {
            maxValue = Math.max(intervals[pointer][1], maxValue);
            pointer++;
        }

        list.add(new int[]{minValue, maxValue});

        while (pointer < intervals.length && intervals[pointer][0] > newInterval[1]) {
            list.add(intervals[pointer]);
            pointer++;
        }

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[] test = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(test, 1));
    }

}
