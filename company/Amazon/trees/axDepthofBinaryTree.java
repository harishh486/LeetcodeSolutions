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
    public int maxDepth(TreeNode root) {
        
        // cinema theatre ::analogy 
        //ur at ur cuurent row and u dont know howmany levels
        //u ask front guy and add 1 o that u can say im at x+1 level
        
        if(root == null)
            return 0; // first row
        int leftheight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        return Math.max(leftheight,rightHeight ) +1; 
        
    }
}


// T: o(n) --n no fo nodes --visit exactly node ocne
// S: worst case if its unbalanced we would go to 0(n) but in balanced one we would go ho height of tree -0(logn)