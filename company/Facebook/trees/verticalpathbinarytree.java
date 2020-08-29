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
    public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList();
    if(root == null)
        return result;
    
    TreeMap<Integer, List<Integer>>  map = new TreeMap(); 
        // for tracking left to right purpoose
    int col=0;    
    int mincol = 0;
    int maxcol = 0;
        
    Queue<Pair<TreeNode, Integer>> q = new LinkedList();
    
    q.add(new Pair(root, col));
    while(!q.isEmpty()){
        
        Pair<TreeNode, Integer> temp = q.poll();
        root = temp.getKey();
        col = temp.getValue();
        
        if(root!=null){
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(root.val);
            mincol = Math.min(mincol,col);
            maxcol = Math.max(maxcol,col);
            if(root.left != null){
                q.add(new Pair(root.left, col-1));
            }
            if(root.right != null){
                q.add(new Pair(root.right, col+1));
            }
        }
        
        
    }
    
    for(int i=mincol;i<=maxcol;i++){
        result.add(map.get(i));
    }
    return result;
        
    
    }
}