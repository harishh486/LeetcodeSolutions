// Diamter:

// Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.


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




 // Diamter:

// Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.


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
    
    static class HD {
        int h;
        int d;
        HD(int h, int d){
            this.h = h;
            this.d =d;
        }
    }

    
    public int diameterOfBinaryTree(TreeNode root) {
        HD hd = heightDiameter(root) ;  
        return hd.d;
    }
    
   HD heightDiameter(TreeNode root){

       if(root == null){
         return new HD(0,0);  
       }
   
       HD lhd = heightDiameter( root.left);
       HD rhd = heightDiameter( root.right);
       
       // All this constant time
       int height = 1+ Math.max(lhd.h, rhd.h);
       int diameter = Math.max( lhd.h+ rhd.h, Math.max(lhd.d, rhd.d));
                                // with node.    without node
       // here with node calculate the height of left and right and max of it and adds 1 so we need not add one again
       //**** imp 

       return new HD(height, diameter);
       
       
       
   }
    
}


// T: o(n) --since we optimized the solution to clauclate the height and dimater of a node at the same tme
// // this was calculating multiple time ...soo for every node it was calculating height and for 
// each node to calculate diamter , it also calculates height again even though it calculated already 
// //repetitive
// --optimized to calculate both at one go
// //recursive calls for every node but have constant time






UNoptimized solution:
===================
class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        
        
        // visulaize the dialmeter node 
        // with node and withhout node
        
        // base case
        if(root == null)
            return 0;
        
        int leftheight = depth(root.left);
        int rightheight = depth(root.right);
        // once we get the height of both elements
        
        //so when ur returning heights of the lst ir rst ur also including the node as well
        
        int leftdiamater = diameterOfBinaryTree(root.left);
        int rightdiamater = diameterOfBinaryTree(root.right);
        return Math.max((leftheight+rightheight), Math.max(leftdiamater,rightdiamater ) );
                        // with node                 // without node
        
        // withh node -- ull get heights from both the lst and rst but u ll also include current node
        //which means (left or right)  +1 
    }
    
    
    
    private int depth(TreeNode root){
        if(root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left, right) +1 ;
    }
}


// T: o(n * h)
// h can vary from logn to n in balance and skewed

// we can optimize for sure becos for every diameter we are having calculating the heights for already calcluated

