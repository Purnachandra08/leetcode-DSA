class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * numRows - 2; // full zigzag cycle

        for (int row = 0; row < numRows; row++) {
            for (int j = row; j < s.length(); j += cycleLen) {
                result.append(s.charAt(j));
                // middle rows need an extra char in between
                int secondChar = j + cycleLen - 2 * row;
                if (row != 0 && row != numRows - 1 && secondChar < s.length()) {
                    result.append(s.charAt(secondChar));
                }
            }
        }

        return result.toString();
    }
}
