/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    
    // Make sure u have a prev ptr available statically or globally so that prev is chnaged at every step
    
    // Algo: for BSt, inorder gives sorted values
    // Since we are asked sorted, modify inorder , left-> proceess ->right
    Node prev;
    public Node treeToDoublyList(Node root) {
        // base 
        if(root == null)
            return null;
        // initially prev points to null
        prev  = new Node(0, null, null);
        Node head = prev;
        convert(root);
        prev.right = head.right;
        head.right.left = prev;
        return head.right;
        
        
        
    }
    private void convert(Node root){
        if(root == null)
            return; // base for recursion
        //Inorder style
        //1. left
        convert(root.left);
        //2. Process
          prev.right = root;
          root.left= prev;
          prev = root;
        //3. right
        convert(root.right);
        
        


    }
}


// T: O(N) since each node is processed exactly on
// S: Eventhough inplace--space for recursive calls
       //O(logn) for balanced
       // 0(N) worst case unbalanced


// Summary:

// Perform Inorder with chnage in process step:

// Everythhing inplace-- space for recursive calls
// 1.u need to have a Prev node and also some head reference as well 
// becos prev keeps on chnaging

// prev  = new Node(0, null, null);
//  Node head = prev;
//                                              P  Root
// 2. call convert  // draw a diagram of dll 1->2-3
//    -- inorder
//       main step

//       if(root == null)
//       return; // base for recursion
//        //Inorder style
//        //1. left
//        convert(root.left);
//        //2. Process
//          prev.right = root;
//          root.left= prev;
//          prev = root;
//        //3. right
//        convert(root.right);
// 3. once converted 
//    rearrange last and first pointers,

//    At this point ,prev points to last node 
//    head is a dummy node so 
//    and we ll return head.right

//    prev.right = head.right;
//    head.right.left = prev;
//    return head.right;
