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
 * 
 */

// Given binary tree [3,9,20,null,null,15,7],
// 3
// / \
// 9  20
// /  \
// 15   7
// return its level order traversal as:
// [
// [3],
// [9,20],
// [15,7]
// ]

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // base
        
        List<List<Integer>> resultList = new ArrayList();
        
        if(root == null)
            return resultList;

            //In Java one could use LinkedList implementation of the Queue interface.
        Queue <TreeNode> q = new LinkedList();
        // initilaize q with root ::initial element shud be root to do some processing
        q.add(root);
        
        // now we ll do until q is empty
        while(!q.isEmpty()){
            int size = q.size(); // to iterate upto that level and weknow how many nodes are there in each level
            //so that we process only that nodes 
            // Need a list to store the temp lists
            List <Integer> tempList = new ArrayList();
            
            // Now iterate thru loop until we reach all the nodes in the level via size
            for(int i=0; i<size;i++){
                //Steps to do
                 // 1. Pop()
                 TreeNode t = q.remove(); //removesthe element from queue 
                //add and remove  || offer and poll work together 
                // Do some operation:: here we are doing insertion to array list
                tempList.add(t.val);
                
                // then insert the left and right sub tree of that node back in the queue
                //maintain order
                // may be we can have a null check since it is complaining here
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
                
            } 
            resultList.add(tempList); // after every level we add lists to final list
           
            
            
        }
        
        return  resultList;
        
        
    }
}


T: o(n) ince each node is processed exactly once.
S: 0(n) -since we are using queue to add and delete operation
to keep the output structure which contains n node values.



