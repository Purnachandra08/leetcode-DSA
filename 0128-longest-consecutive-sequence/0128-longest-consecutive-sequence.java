class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, false);
        }

        for (int num : nums) {

            if (map.get(num))
                continue;

            map.put(num, true);

            int currentLength = 1;

            int nextNum = num + 1;
            while (map.containsKey(nextNum) && !map.get(nextNum)) {
                currentLength++;
                map.put(nextNum, true);
                nextNum++;
            }

            int prevNum = num - 1;
            while (map.containsKey(prevNum) && !map.get(prevNum)) {
                currentLength++;
                map.put(prevNum, true);
                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }

        return longestLength;
    }
}