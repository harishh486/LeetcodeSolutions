//Binary tree-- bunch of nodes where each nodes has atmodt 2 childs
//0 1 2  nodes

//lca == node that    : where it splits from  itself and go in two differnet paths


// TIP:  Assume only one node when colving tree recursive prob;lems

//     root
//    /  \ 
//    l   r 





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //Binary tree-- bunch of nodes where each nodes has atmodt 2 childs
//0 1 2  nodes

//lca == node that    : where it splits from  itself and go in two differnet paths


// TIP:  Assume only one node when colving tree recursive prob;lems

//     root
//    /  \ 
//    l   r 


        //base cases
        
        if( root == null)
            return null;
        
        // if any one of the value of two nodes is root then that is the lca
        if(root.val == p.val || root.val ==  q.val)
            return root;
        
        //recursively search both nodes
        TreeNode lst = lowestCommonAncestor(root.left, p,q);
        TreeNode rst = lowestCommonAncestor(root.right, p,q);
        // Analyze the results from. stack calls
        if(lst == null) return rst;
        if(rst == null) return lst;// if one of thrm id null then return th othr node
        //if both of them are not null then we return root because that is lca
        if(lst == null && rst == null) return null;

        // if both return soemething return root beco its lca
        return root;
        
        
        
        
    }
}

// T: o(n)- no of nodes
// S: o(h)- height of tree