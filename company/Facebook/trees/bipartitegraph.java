class Solution {
    public boolean isBipartite(int[][] graph) {
        int vertices = graph.length;
        int[] color = new int[vertices];
        Arrays.fill(color,-1);
        // init all v ertices color to -1

        // for each vertices,
        for(int i=0;i<vertices; i++){
            // check if vertex is not colored
            if(color[i] == -1){
                // do bfs
                Queue<Integer> q = new LinkedList();
                q.add(i); // push init vertx
                color[i] = 0; // make the init vertex with some color ,0
                
                while(!q.isEmpty()){
                    // pop the evrtx and check its neighbors
                    Integer poppedVertex = q.poll();
                    // then check its all neighbrs whetherit is color or not
                    for(int neigh: graph[poppedVertex]){
                        if( color[neigh] == -1){
                            // if its not colored, add to q and color it opposite
                            q.add(neigh);
                            color[neigh] = color[poppedVertex] ^ 1; //this is how we chnage the color   
                        }
                        else if(color[neigh] == color[poppedVertex]){
                            return false;
                        }
                    }
                }
                
            }
        }
        
        return true;

    }
}


// Summary:
        
// //  for all vertices: 
//       if its not colored:
//          do bfs
//          create q, add init vertex, and also color initaly vertx to 0;
//          while(q is notEmpty){
//              1. pop the vertex
//              2. get their neighbours of popped one: using int neigh: graph[poppedVertex]
//              3. for all neighbors
//                  check if its not colored
//                     then add to q and color it color[neigh] = color[poppedVertex] ^ 1;
//                  check if its neighbour is colored, and also matches the poppedVertex, then return false;
             
//              After qhile loop success, we have traverses and everything is true and return true;
             
//          }

// Time :O(N+E), where N is the number of nodes in the graph,
//  and E is the number of edges. 
//  We explore each node once when we transform it from uncolored to colored, traversing all its edges in the process.

// Space : O(N), the space used to store the color