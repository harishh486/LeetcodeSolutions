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
        
        // Hints --what we got-- top to bottom--mostly use bfs--which means-queue
        //  so we need the right view which means if u think we end up having right most value in that level
        // imagine a tree, level by level lets say, the last rightmost element u see will be the right view.
        
        
        List<Integer> visibleValues = new ArrayList<>();
        if(root == null)
            return visibleValues;
        //since we are going for queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ///typical bfs
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size;i++){
                TreeNode current = q.remove(); //remove that node which we are processing
                if(i== size-1){
                    //meaning the last element in the level, since we add all elements in that level in queue
                    visibleValues.add(current.val);
                    
                }
                if(current.left !=null)
                    q.add(current.left);
                if(current.right != null)
                    q.add(current.right);
            }
        }
        
        return visibleValues;
        
    }
}


// T: o(N)
// S: 0(N)

format--template

// Queue<TreeNode> q = new LinkedList<>();
// q.add(root);

// while(!q.isEmpty()){
//     int size = q.size(); --- important
//     for(int i=0; i< size;i++){  -inportant
//         TreeNode current = q.remove(); //remove that node which we are processing
//         if(i== size-1){
//         }
//         if(current.left !=null)  - tarverse left and right --iportant
//             q.add(current.left);
//         if(current.right != null)
//             q.add(current.right);
//     }
//     return result
// }