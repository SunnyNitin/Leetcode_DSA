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
    public int diameterOfBinaryTree(TreeNode root) {
        int maxi[] = new int[1];
        findHeight(root, maxi);
        return maxi[0];
    }

    public int findHeight(TreeNode root, int Maxi[]){
        if(root == null){
            return 0;
        }
        int leftHeight = findHeight(root.left, Maxi);
        int rightHeight = findHeight(root.right, Maxi);
        Maxi[0] = Math.max(Maxi[0], leftHeight + rightHeight);
        return (1 + Math.max(leftHeight, rightHeight));
    }
}