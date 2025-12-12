class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            // If mid is less than next element, peak is on the right side
            if(nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                // Peak is on the left side (including mid)
                right = mid;
            }
        }

        // left == right, both point to the peak element index
        return left;
    }
}
