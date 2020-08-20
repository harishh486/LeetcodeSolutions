/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    HashMap<Integer, Node> map = new HashMap();
    public Node cloneGraph(Node node) {
        // since it  is a graph--my first thought would be dfs/bfs in order to traverse
        // deep copy kind of problems--we have seen-using hashmap to get old and new node reference together
       // standard recursive pattern
        return cloneRecur(node); // solving using dfs--stack recursive
    }
    private Node cloneRecur(Node node){
        // base condition
        if(node == null)
            return null;
        // 2 cases
        // 1. if we already have a niode in map--return that
        // 2. if not create one and get those neighbours to the clone node using the neighbours of old node and return the new clone node pkg(clone node + its neighbours)
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }else{
            // we create one 
            Node clone =  new Node(node.val);
            // u also need to put the node in to hahsmap--***
            map.put(node.val, clone);
            
            for (Node neighbor:  node.neighbors){
                // we need to add neighbours of every node to cloned node
                clone.neighbors.add(cloneRecur(neighbor));
            }
            return clone;
        }
        
    }
}



// T: 0(N) -- we need to visit each node

// S: 0(N) --store all nodes in map
//  This space is occupied by the visited hash map and in addition to that, 
//  space would also be occupied by the recursion stack since we are using a recursion. 
//  The space occupied by the recursion stack would be equal to O(H) where H is the height of the graph. 
//  Overall, the space complexity would be O(N).