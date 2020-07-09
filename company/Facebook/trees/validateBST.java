// BST --allow us to efficiently store and update, in sorted order, a dynamically changing datase
// When binary search trees are balanced, average time complexity for insert and find is O(log n), which is very efficient as our dataset grows.
//  BST -- has max of two childs


// full: every node has either zero or two children. Nodes do not have only one child.
// complete: every level in the tree is fully filled with the possible exception of the last level, which should be filled from left to right.
// perfect: it is both full and complete and must have exactly 2^(n -1) nodes.



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
       
       return validate(root, null, null);
       
   }
   
   public boolean validate(TreeNode root, Integer max, Integer min){
       if (root == null){
            return true; 
       }else if(max != null && root.val >= max || min != null && root.val <= min) {
           return false;
           
       }else {
           return validate(root.left,root.val,min) && validate (root.right, max, root.val);
       }
           
   }
}


T: o(n) --since it needs to traverse every node in the tree
S: o(n) --worst case can be ;since the most recursive stack calls to process  all nodes
