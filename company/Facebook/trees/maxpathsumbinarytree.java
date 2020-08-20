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
    int max_path_sum;
    public int maxPathSum(TreeNode root) {
        max_path_sum = Integer.MIN_VALUE;
        pathSum(root);
        return max_path_sum;  
    }
    
    int pathSum(TreeNode root){
        if(root == null)
            return 0;
        // traverse left and right recursively, if we find negative we ll return 0 
        int left = Math.max(0, pathSum(root.left));
         int right = Math.max(0, pathSum(root.right));
        //update max path sum if its greater than existing max path sum
        //Now check to continue the old path or to start a new path. To start a new path would cost price_newpath = node.val + left_gain + right_gain. Update max_sum if it's better to start a new path
        max_path_sum = Math.max(max_path_sum, left+right+root.val);
        //In other words, it's a  pathsum one could have including the node (and maybe one of its subtrees) into the path
        //return the pathSum the node and one/zero of its subtrees could add to the current path : node.val + max(left_gain, right_gain)
        return Math.max(left, right) + root.val;
        // we use max_sum to get the local max value, but we want to get the new path from its upper node and to see if it will give us a bigger sum. Imagine we want to get one level up node's max_sum(we call this node "a"), since it can be a'left child ->a -> a'right child, and we can use this to update our max_sum, however, if we want to get one more upper node's max sum, say it is node 'b', the max_sum should (b+ a + a.left_child )or ( b+ a + a.right_child), so that is why we return node + Math.max(node.left, node.right)
}



// T: o(N) where N is number of nodes
// S: o(H) -logn height