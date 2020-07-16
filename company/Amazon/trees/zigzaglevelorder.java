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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        // same like  level order tree except we manipulate linked list on how to insert either append or insert at first position
        //leverage that and also we try to decide that at every level using a level flag so that based pon this we can decide where to insert , rest everything is same
        // Achieved using BFS -- QUEUE
        
        
         List<List<Integer>> result = new ArrayList();
        
        if(root == null)
            return result;
         
        //Define a queue //linked list implementation of queue interface
        Queue<TreeNode> q = new LinkedList();
        boolean orderFlag = true;
        
        
    // insert a  root node initialy to queue
        q.add(root);
        
        while(!q.isEmpty()){
            // do some operations
            int size = q.size();
            //maintain a list to add all elements at each level and we will traverse the level until size 
            LinkedList<Integer> tempList = new LinkedList();
            for(int i=0; i<size; i++){
                //1. pop
                TreeNode t = q.remove();
                //2.  here comes the main tricky insertion logic
                // we will leverage list append and insert at oth index functionality based on some flag        
                if(orderFlag)
                    tempList.add(t.val);
                else
                    tempList.add(0, t.val);
                
                //3. push thye left and right nodes and check null before pushing
                if(t.left !=null)
                    q.add(t.left);
                if(t.right !=null)
                    q.add(t.right);
            }
            //add the list at the level with all nodes in that level to result
            //And also change the flag for next level
            result.add(tempList);
            orderFlag = orderFlag ? false :true;
            
        }
        return result;
        
  
        
    }
}

T: o(n) ince each node is processed exactly once.
S: 0(n) -since we are using queue to add and delete operation
to keep the output structure which contains n node values.