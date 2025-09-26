import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        // Add all elements of nums1 into list1
        for (int num : nums1) {
            list1.add(num);
        }

        // Check nums2 elements against list1
        for (int num : nums2) {
            if (list1.contains(num)) {
                result.add(num);
                list1.remove(Integer.valueOf(num)); // remove matched element
            }
        }

        // Convert result list into array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
