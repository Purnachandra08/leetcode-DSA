class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        StringBuilder ans = new StringBuilder();
        String a = strs[0];
        String b = strs[strs.length-1];
        for(int i = 0;i<a.length();i++){
            if(a.charAt(i)==b.charAt(i)){
                ans.append(a.charAt(i));
            }else break;
        }
        return ans.toString();
    }
}