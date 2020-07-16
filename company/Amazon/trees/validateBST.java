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
    public boolean isValidBST(TreeNode root) {
        
        return validateHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
        
    }
    private boolean validateHelper(TreeNode root, long min, long max){
        // base condition
        //every null node is a BST
        if (root == null)
            return true;
        
        
        // if root.val is not in betweeen the min and max strict- return false
        
        if(root.val <= min || root.val >=max){
            return false;
            
        }
        // if it falls in betwwen the min and max , then recursively do it for subtrees
        return validateHelper(root.left, min, root.val) && validateHelper(root.right, root.val, max);
            
    }
}


// T: o(n)
// S:o(d)--depth of tree
// longest length of the tree
// --it is the optimal and evem recursive is same