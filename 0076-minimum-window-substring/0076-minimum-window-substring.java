class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        HashMap<Character, Integer> map = new HashMap<>();

        // Frequency of characters in t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int count = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) >= 0)
                    count--;
            }

            while (count == 0) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {

                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0)
                        count++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}