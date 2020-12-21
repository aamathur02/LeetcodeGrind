package Easy.Strings;

import java.util.HashMap;

public class Solution {

    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp  = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }

    public int reverseInt(int input) {
        int result = 0;
        while (input != 0) {
            int pop = input % 10;
            input /= 10;

            if (pop > Integer.MAX_VALUE / 10 || (pop == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (pop < Integer.MIN_VALUE / 10 || (pop == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    public int firstUniqueChar(String s) {
        int[] array = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (array[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            Character ch = c;
            if (map.containsKey(ch)) {
                map.put(ch, map.get(c) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }

    public boolean isPalindrome(String s) {
        int left=0; int right=s.length()-1;

        while(right>left){

            while(right>left && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            while(right>left && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if(right>left && Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }

        return true;
        //asdsa
    }

    public int myAtoi(String s) {
        int counter = 0;
        int result = 0;

        if (s.length() == 0) return 0;

        while (counter < s.length() && s.charAt(counter) == ' ') {
            counter++;
        }
        boolean negative = false;
        if (counter < s.length() && (s.charAt(counter) == '+' || s.charAt(counter) == '-')) {
            negative = s.charAt(counter++) == '+' ? false : true;
        }

        while (counter < s.length() && s.charAt(counter) >= '0' && s.charAt(counter) <= '9') {
            if (result > Integer.MAX_VALUE / 10  || (result == Integer.MAX_VALUE / 10 && s.charAt(counter) - '0' > Integer.MAX_VALUE % 10)) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
           result = result * 10 + (s.charAt(counter) - '0');
           counter++;
        }

        return negative ? -result : result;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) !=0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}