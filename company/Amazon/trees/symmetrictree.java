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
    public boolean isSymmetric(TreeNode root) {
        //base case
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
        
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if (left == null || right == null)
            return left==right;
        if(left.val != right.val)
            return false; // no point in comparison  if we  dont match the values
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}


// T: o(n)  we traverse the entire input tree once
// S: o(D)--he number of recursive calls is bound by the height of the tree


Itrative -- // iterative approach// billion records--> stack overflow


class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        // iterative approach// billion records--> stack overflow
        if (root == null)
            return true; // orlese ask interview er wht needs to return :: good to ask
        // initilze a queue FIFo
        Queue<TreeNode> q = new LinkedList();
        
        // we will pick 2 element nodes and try to compare them and everytime it shud be equal else not symmetric
        // we also need to insert in certain way to be symmetric
        // we will initiaize 2 nodes initially as roots only
        // then later on left sub tree an d right sub tree
        q.add(root);
        q.add(root);
        
        while(!q.isEmpty()){
            // do the oprations until queu is empty
            
            TreeNode t1 =  q.poll();
            TreeNode t2 =  q.poll(); //FIFO order
            
            if(t1 == null && t2 == null)
                 continue; // important becos there might be next elemnts after two consecutuve nulls
            
            
            if(t1 == null || t2 == null )
                return false;
            
            if(t1.val !=  t2.val)
                return false;
            
            // now we completed all comparisons
            // we need to insert in a better way to check symm
            
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        
        return true;
        
        
            
        
        
        
        
    
        
    }
    
}