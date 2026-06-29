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
    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return (height != -1);    
    }

    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        // post oreder traversal
        int leftSubTreeHeight = getHeight(root.left);
        int rightSubTreeHeight = getHeight(root.right);
        if(leftSubTreeHeight == -1  || rightSubTreeHeight == -1){
            return -1;
        }
        if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1){
            return -1;
        }
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
}