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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            // root.val == key
            // leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // single child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                //2 child case.
                //inoreder predecessor
                TreeNode node = findPredecessor(root.left);
                //shift the node
                root.val = node.val;
                // delete node.val
                root.left = deleteNode(root.left, node.val);
            }
        }
        return root;
    }

    public TreeNode findPredecessor(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
}