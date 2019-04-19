import sun.text.normalizer.Trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {

    // Brute Force
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    private static boolean allUnique(String s, int i, int j) {
        Set<Character> characterSet = new HashSet<>();
        for (int k = i; k < j; k++) {
            char ch = s.charAt(k);
            if (characterSet.contains(ch)) return false;
            characterSet.add(ch);
        }
        return true;
    }

    public static int lengthSlidingWindow(String s) {
        int n = s.length();
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < n && j < n) {
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthHashMap(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String ex1 = "abcabcab";
        String ex2 = "bbbbb";
        String ex3 = "pwwkew";

        if (lengthOfLongestSubstring(ex1) != 3) {
            System.out.println("Example 1 failed");
        }
        if (lengthOfLongestSubstring(ex2) != 1) {
            System.out.println("Example 2 failed");
        }
        if (lengthOfLongestSubstring(ex3) != 3) {
            System.out.println("Example 3 failed");
        }

        if (lengthSlidingWindow(ex1) != 3) {
            System.out.println("Example 1 failed");
        }
        if (lengthSlidingWindow(ex2) != 1) {
            System.out.println("Example 2 failed");
        }
        if (lengthSlidingWindow(ex3) != 3) {
            System.out.println("Example 3 failed");
        }

        if (lengthHashMap(ex1) != 3) {
            System.out.println("Example 1 failed");
        }
        if (lengthHashMap(ex2) != 1) {
            System.out.println("Example 2 failed");
        }
        if (lengthHashMap(ex3) != 3) {
            System.out.println("Example 3 failed");
        }
    }
}

