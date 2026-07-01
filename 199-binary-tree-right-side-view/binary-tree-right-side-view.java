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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // bfs
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll(); // top most node remove from queue.
                if(node.left != null){
                    queue.offer(node.left); // insert left node in queue.
                }
                if(node.right != null){
                    queue.offer(node.right); // insert right node in queue.
                }
                size -- ;
                if(size == 0){
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}