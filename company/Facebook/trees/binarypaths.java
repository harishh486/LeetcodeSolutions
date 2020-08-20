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
    List<String> result =  new ArrayList();
    
    public List<String> binaryTreePaths(TreeNode root) {
        // since we need full path--think of dfs
        // regular template
        // additional String -> addition
        if(root == null)
            return result;
        
        dfs(root,"");
        return result;
        
    }
    private void dfs(TreeNode node, String currentPath){
        currentPath += node.val; // we ll add everynode in the path that we traverse
        
        if(node.left == null && node.right == null){
            // once we reach to leaf node then add the current path we built till now
            result.add(currentPath);
            return;
        }
        //if not , recurse left and right
         if(node.left != null)
           dfs(node.left, currentPath + "->"); //
         if(node.right != null)
           dfs(node.right, currentPath + "->"); //
    }
}


//Approach
// 1. path --immediate trike--dfs/bfs
// 2. whole paths--may be dfs
// 3. dfs template with iniyial path "" ====> dfs(root,"");

// 4. Base condition -- if leaf nodes then we add the cuureent path built till now and add to result
// 5. otherwise we ll add the everynode we encounter to current path till we reach leaf nodes

// T: o(N) -since we visit each nodes 
// S: 

// Space: O(Lh). L is the number of leaves / paths.
// - Stack frame: O(h)
// - result list: O(Lh)
// - For a bushy tree: Number of leaves is ~ N/2, and the height is logN. So the space complexity is O(NlogN).
// - For a spindly tree: Number of leaves is ~ O(1), but the height is N. So the space complexity is O(N).


