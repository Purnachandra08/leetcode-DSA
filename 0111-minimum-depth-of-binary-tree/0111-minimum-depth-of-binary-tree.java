/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // If one subtree is missing, return the other + 1
        if (left == 0 || right == 0) {
            return Math.max(left, right) + 1;
        }

        // Both sides exist, take the minimum
        return Math.min(left, right) + 1;
    }
}
