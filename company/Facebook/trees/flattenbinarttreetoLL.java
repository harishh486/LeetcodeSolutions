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


 // Flatten logic is not like compete LL
 // have only right nodes and left should be null
 // use a stack
 //pop() -- "pop" means the method of returning an object from a stack, while at the same time removing it from the stack. 
 //peek() --T "Peek" always means "give me the next item but do not remove it from the container"
 //logic

 // take the root node, and push to stack as initial one, then iterate from the root  node in the stack
 // while loop
 // check if stack is not empty and do
 // take the current node from stack using pop(), then do operation on current node like current.right is not null the push right, else push left
 //always push right first and then left to be in line, then assign current.right to peek()

 //also curr.left is always null

 //*** make sure currnode is taken and not root while logic *** 


class Solution {
    public void flatten(TreeNode root) {
        
        
        if (root == null)
            return;
        
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        
        while(!stack.isEmpty()){
            
            TreeNode current_node = stack.pop();
            
            if(current_node.right != null ){
                stack.push(current_node.right);
            }
            if(current_node.left != null){
                stack.push(current_node.left);
            }
            
            if(!stack.isEmpty()){
                current_node.right = stack.peek();
            }
            
            current_node.left = null;
        }
        
    }
}

T: o(n) --proces all nodes

s:0(n) -- store all nodes max
