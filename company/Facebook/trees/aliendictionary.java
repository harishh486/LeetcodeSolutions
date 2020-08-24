class Solution {
    public String alienOrder(String[] words) {
        // Summary
        //1. first. build a graph using adhjacency list with its dependencies
        //2. Also build a indegree array to track how many indegrees are present for a node
        // if(words.length == 0)
        //     return "";
        // indegree array 
        int[] indegree = new int[26];
        //adj list--hashmap
        HashMap<Character, Set<Character>> adjList = new HashMap();
        // 2 major steps
        buildGraph(words,indegree,adjList );
        return topologicalSortDfs(indegree,adjList );
        
    }
    
    // build a dependency graph using adjlist and also update the indegree array
    
    private void buildGraph(String[] words,int indegree[], HashMap<Character, Set<Character>> adjList){
        // initialise the adj list graph with all charac ters in all words
        for(String word:words ){
            for(char c: word.toCharArray()){
                adjList.putIfAbsent(c, new HashSet());
            }
        }// once u fill with init,  then u eatblish relationships
        
        // wrt and er 
        for(int i=1; i<words.length;i++){
            String first = words[i-1];
            String second = words[i];
            // now compare each char in thos words
            for(int j=0; j< Math.min(first.length(),second.length());j++){
                if(first.charAt(j) != second.charAt(j)){
                    // a->b here out=a, in=b
                    char out = first.charAt(j);
                    char in = second.charAt(j);
                    // a->b , so in adj list. we need to insert the valiue if not present
                    // if the graph does not contains dependecny, which is in set, u add it else u dont add// since hashset, we can check usinhg contains i guess
                    if(! adjList.get(out).contains(in)){
                        adjList.get(out).add(in);
                        //also increase the indegree if u find the dependency
                        indegree[in -'a']++;
                    }
                    // once it is found , u can break out th e loop
                    break;
                    
                }// if eqaual we mmove to next char and do the process
            }
        }
    }
    
    // here we follow topological sort, 
    private String topologicalSortDfs(int indegree[], HashMap<Character, Set<Character>> adjList){
        
        // we ll use stringbuilder to update the characters instead of string
        // we ll insert all elements into queue who has indegree==0 initially, which means they dont have any dependency so they can come at any time//
        // so insert all indgree==0 into queu and do a stanmdard queue template
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList();
        int totalChars = adjList.size(); // to check at end if all are present
        
        
        // loop thru all keys in graph and check the indegree of that character in indegree if its has zero , if so then  add to queue initially
        // initial push to queue
        for(char c: adjList.keySet()){
            if(indegree[c-'a'] == 0){
                
                sb.append(c);
                q.offer(c);// so u need to add all orphan nodes to sb , since it contains results
            }
            
        } 
        // now we need to find nodes which has dependency, take it out and reduce the indegree and check if indegreeis zero then add tio queue
        
        // stand ard queue template
        while(!q.isEmpty()){
            // take the elemnt 
            char curr = q.poll();
            
            if(adjList.get(curr) == null || adjList.get(curr).size()==0 ){
                // we shud not do antthing, and pick the next nodes in the queue
                continue;
            }
            // if we have some elements in the adj list which means we have a dependency
            // So what do we do here:??
            // i think we can take it and reduce the indgree ??
           //   Since we are. removing this particular current element, so we need to reduce all its neighbour indegree becios we removed aos we need to update the indegree of all its neiughbours
            for(char neighbour : adjList.get(curr)){
                indegree[neighbour-'a']--;
                //also check if it becomes zero after update we need to push to queu and sb
                if(indegree[neighbour-'a'] == 0){
                    //add to q and sb
                    q.offer(neighbour);
                    sb.append(neighbour);
                    
                }
            }
            
        }
        
        // once we are out of queue, which means we processed all nodes
        // if total chars is sb length, which means we got all chars /nodes so we can return else ""
        return sb.length() == totalChars ? sb.toString() : "";
    }
    
    
}


// * There exists an edge case, Lets say there are two strings: s1 = abc s2 = ab
// * In this case, can we exactly determine the order of chars ?, answer is NO. In
// * this case, the order of the string is a problem. The prefixes should always
// * be before a string if its lexographically sorted. So, "ab" cant come after
// * "abc". So, we need to return "" if we find prefix after the string itself. this can
// * be addressed like below when two strings are s1 and s2
// * 
// * if(s1.length()> s2.length() && s1.startsWith(s2)) return ""

--this is not addressed in above code , but addressed in below code







Working Solution:



class Solution {
    public String alienOrder(String[] words) {
        // Summary
        //1. first. build a graph using adhjacency list with its dependencies
        //2. Also build a indegree array to track how many indegrees are present for a node
        // if(words.length == 0)
        //     return "";
        // indegree array 
        int[] indegree = new int[26];
        //adj list--hashmap
        HashMap<Character, Set<Character>> adjList = new HashMap();
        // 2 major steps
        // buildGraph(words,indegree,adjList );
        
                // initialise the adj list graph with all charac ters in all words
        for(String word:words ){
            for(char c: word.toCharArray()){
                adjList.putIfAbsent(c, new HashSet());
            }
        }// once u fill with init,  then u eatblish relationships
        
        // wrt and er 
        for(int i=1; i<words.length;i++){
            String first = words[i-1];
            String second = words[i];
            
            // important edge case
            if(first.length()> second.length() && first.startsWith(second))
                return "";
            // now compare each char in thos words
            for(int j=0; j< Math.min(first.length(),second.length());j++){
                if(first.charAt(j) != second.charAt(j)){
                    // a->b here out=a, in=b
                    char out = first.charAt(j);
                    char in = second.charAt(j);
                    // a->b , so in adj list. we need to insert the valiue if not present
                    // if the graph does not contains dependecny, which is in set, u add it else u dont add// since hashset, we can check usinhg contains i guess
                    if(! adjList.get(out).contains(in)){
                        adjList.get(out).add(in);
                        //also increase the indegree if u find the dependency
                        indegree[in -'a']++;
                    }
                    // once it is found , u can break out th e loop
                    break;
                    
                }// if eqaual we mmove to next char and do the process
            }
        }
        
        
        
        
        
        
//         return topologicalSortDfs(indegree,adjList );
        
        
        
                // we ll use stringbuilder to update the characters instead of string
        // we ll insert all elements into queue who has indegree==0 initially, which means they dont have any dependency so they can come at any time//
        // so insert all indgree==0 into queu and do a stanmdard queue template
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList();
        int totalChars = adjList.size(); // to check at end if all are present
        
        
        // loop thru all keys in graph and check the indegree of that character in indegree if its has zero , if so then  add to queue initially
        // initial push to queue
        for(char c: adjList.keySet()){
            if(indegree[c-'a'] == 0){
                
                sb.append(c);
                q.offer(c);// so u need to add all orphan nodes to sb , since it contains results
            }
            
        } 
        // now we need to find nodes which has dependency, take it out and reduce the indegree and check if indegreeis zero then add tio queue
        
        // stand ard queue template
        while(!q.isEmpty()){
            // take the elemnt 
            char curr = q.poll();
            
            if(adjList.get(curr) == null || adjList.get(curr).size()==0 ){
                // we shud not do antthing, and pick the next nodes in the queue
                continue;
            }
            // if we have some elements in the adj list which means we have a dependency
            // So what do we do here:??
            // i think we can take it and reduce the indgree ??
           //   Since we are. removing this particular current element, so we need to reduce all its neighbour indegree becios we removed aos we need to update the indegree of all its neiughbours
            for(char neighbour : adjList.get(curr)){
                indegree[neighbour-'a']--;
                //also check if it becomes zero after update we need to push to queu and sb
                if(indegree[neighbour-'a'] == 0){
                    //add to q and sb
                    q.offer(neighbour);
                    sb.append(neighbour);
                    
                }
            }
            
        }
        
        // once we are out of queue, which means we processed all nodes
        // if total chars is sb length, which means we got all chars /nodes so we can return else ""
        return sb.length() == totalChars ? sb.toString() : "";
    }
    
    
        
    }
    
    // build a dependency graph using adjlist and also update the indegree array
    
//     private void buildGraph(String[] words,int indegree[], HashMap<Character, Set<Character>> adjList){
//         // initialise the adj list graph with all charac ters in all words
//         for(String word:words ){
//             for(char c: word.toCharArray()){
//                 adjList.putIfAbsent(c, new HashSet());
//             }
//         }// once u fill with init,  then u eatblish relationships
        
//         // wrt and er 
//         for(int i=1; i<words.length;i++){
//             String first = words[i-1];
//             String second = words[i];
//             // now compare each char in thos words
//             for(int j=0; j< Math.min(first.length(),second.length());j++){
//                 if(first.charAt(j) != second.charAt(j)){
//                     // a->b here out=a, in=b
//                     char out = first.charAt(j);
//                     char in = second.charAt(j);
//                     // a->b , so in adj list. we need to insert the valiue if not present
//                     // if the graph does not contains dependecny, which is in set, u add it else u dont add// since hashset, we can check usinhg contains i guess
//                     if(! adjList.get(out).contains(in)){
//                         adjList.get(out).add(in);
//                         //also increase the indegree if u find the dependency
//                         indegree[in -'a']++;
//                     }
//                     // once it is found , u can break out th e loop
//                     break;
                    
//                 }// if eqaual we mmove to next char and do the process
//             }
//         }
//     }
    
    // here we follow topological sort, 
//     private String topologicalSortDfs(int indegree[], HashMap<Character, Set<Character>> adjList){
        
//         // we ll use stringbuilder to update the characters instead of string
//         // we ll insert all elements into queue who has indegree==0 initially, which means they dont have any dependency so they can come at any time//
//         // so insert all indgree==0 into queu and do a stanmdard queue template
//         StringBuilder sb = new StringBuilder();
//         Queue<Character> q = new LinkedList();
//         int totalChars = adjList.size(); // to check at end if all are present
        
        
//         // loop thru all keys in graph and check the indegree of that character in indegree if its has zero , if so then  add to queue initially
//         // initial push to queue
//         for(char c: adjList.keySet()){
//             if(indegree[c-'a'] == 0){
                
//                 sb.append(c);
//                 q.offer(c);// so u need to add all orphan nodes to sb , since it contains results
//             }
            
//         } 
//         // now we need to find nodes which has dependency, take it out and reduce the indegree and check if indegreeis zero then add tio queue
        
//         // stand ard queue template
//         while(!q.isEmpty()){
//             // take the elemnt 
//             char curr = q.poll();
            
//             if(adjList.get(curr) == null || adjList.get(curr).size()==0 ){
//                 // we shud not do antthing, and pick the next nodes in the queue
//                 continue;
//             }
//             // if we have some elements in the adj list which means we have a dependency
//             // So what do we do here:??
//             // i think we can take it and reduce the indgree ??
//            //   Since we are. removing this particular current element, so we need to reduce all its neighbour indegree becios we removed aos we need to update the indegree of all its neiughbours
//             for(char neighbour : adjList.get(curr)){
//                 indegree[neighbour-'a']--;
//                 //also check if it becomes zero after update we need to push to queu and sb
//                 if(indegree[neighbour-'a'] == 0){
//                     //add to q and sb
//                     q.offer(neighbour);
//                     sb.append(neighbour);
                    
//                 }
//             }
            
//         }
        
//         // once we are out of queue, which means we processed all nodes
//         // if total chars is sb length, which means we got all chars /nodes so we can return else ""
//         return sb.length() == totalChars ? sb.toString() : "";
//     }
    
    
