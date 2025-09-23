class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect intersection point of cycle
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];        // move one step
            fast = nums[nums[fast]];  // move two steps
        } while (slow != fast);
        
        // Phase 2: Find entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}