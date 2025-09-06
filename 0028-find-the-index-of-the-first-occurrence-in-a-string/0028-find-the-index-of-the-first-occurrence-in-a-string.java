class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int n = haystack.length(), m = needle.length();
        int[] lps = new int[m];
        
        // Build LPS
        for (int i = 1, len = 0; i < m;) {
            if (needle.charAt(i) == needle.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        
        // Search
        for (int i = 0, j = 0; i < n;) {
            if (haystack.charAt(i) == needle.charAt(j)) { i++; j++; }
            if (j == m) return i - m;
            else if (i < n && haystack.charAt(i) != needle.charAt(j)) 
                j = (j > 0) ? lps[j - 1] : i++ - i + 1; 
        }
        return -1;
    }
}
