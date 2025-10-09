import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int length = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                length += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if (!set.isEmpty()) {
            length += 1; // one odd character can be placed in the center
        }

        return length;
    }
}
