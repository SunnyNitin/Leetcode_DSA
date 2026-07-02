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
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode templeft = root.left;
        TreeNode tempright = root.right;
        root.left = null;
        flatten(templeft);
        flatten(tempright);
        root.right = templeft;
        TreeNode current = root;
        while(current.right != null) current = current.right;
        current.right = tempright;
    }
}