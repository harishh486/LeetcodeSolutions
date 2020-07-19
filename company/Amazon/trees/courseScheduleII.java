class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
         //Base cases
        
        if(prerequisites == null)
            throw new IllegalArgumentException("Not a valid prreq");
        
        int[] result = new int[numCourses];
        
        if(prerequisites.length == 0){
            for(int i=0; i<numCourses; i++)
                result[i]=i;
            return result;
                
        }
        
        
        
        
        // Seems like a graph problem based on my instinct
        // in order to build a graph or represent we need some kind of adj list or some other form to represent
        // we ll take adj lists here , 
        
        // Adj list consists of numofcourses, and the list of courses that depends on this course
        Map<Integer, List<Integer>> adjNeighbourMap = buildAdjacentListMap( numCourses,  prerequisites);
        
        int[] InDegree = buildInDegree(numCourses,  prerequisites);
        
        // now we have Indegree and Adj list
        // we ll go thru indegree array and check if there are any courses whose value is zero and well push that elements into queue in the first pass;
        // we need bfs-- so use Queue
        Queue<Integer> q = new LinkedList();
        
        //pus elemnets initially using Indegree with 0 value init --meaning there are available to complete without any dependcy
        for(int i =0 ;  i<numCourses; i++ ){
            if(InDegree[i]  == 0)
                q.add(i); // make sure u add index and not InDegree[i] in to the queue becos it has a differnet meaning
        }
        
        // now we ll sue traditional bfs::queue logic 
        // until q is empty, pop() ==>. operation ==> push
        
        int counter =0;
        int k=0;
        
        while(!q.isEmpty()) {
            int currentCourse = q.poll();
            result[k++] = currentCourse;
            // we ll take this course and check in adjacency list if we have any neighbours
            // we llmaintain a counter, whenever we pop an element which means we completed the course
            //so we are. reaching near our target and atlast we compare our target and counter to see if we are able to complete all courses
            
            counter++;  // incr as soon as we pop elements
            
            for(int neighbours : adjNeighbourMap.get(currentCourse)){
                // we ll take the neigbours if we have and reduce the neighbours,
                //since we completed the current course by removing from queue, that courses which depends on this course needs to be reduced and also check if they are 0 then they need to push,
                InDegree[neighbours]--;
                if(InDegree[neighbours] == 0)
                    // u need to push this into the queue
                    q.add(neighbours);

            }
   
        }
        
       if(counter == numCourses){
           return result;
       } // wehich means we already completed all course
        else{
            return new int[] {};
        }

        
    }
    
    
    private int[] buildInDegree(int numCourses, int[][] prerequisites){
        
        // we ll try to miantian indegree as incidents in nodes
        //iterate thru prereq and fill the indegree 
        
        int[] inDegreeArray = new int[numCourses];
        
        //[1,0] ==> 1<-0
        for(int[]pre :prerequisites){
            inDegreeArray[pre[0]]++;
             
        }  
        return inDegreeArray;
   
    }
    
    
    
    private Map<Integer, List<Integer>> buildAdjacentListMap(int numCourses, int[][] prerequisites){
        
        // we ll. create on emap , becos w e have to return one
        
        Map<Integer, List<Integer>> adjResultMap = new HashMap();
        
        // first we ll fill all the courses with empty list then we ll add the dependcies
        for(int i=0; i< numCourses; i++){
            adjResultMap.put(i, new ArrayList());    
        }
        
        //now we need to iterate thru prereqs and fill the map
        //[[1,0]] ===> 1 <- 0   ---we need complete 0 before taking 1
        //so here we ll take 1 and its list that depends on it in map
            
        for (int[] pre:prerequisites ){
            
            
             // [[1,0] [2,0]]
            //      1<-0->2
            //          0,--> [1,2]
            
            int courseC = pre[1];
            int courseThatDependsonCourseC = pre[0];
            //we ll get that course and add the list
            List<Integer> list = adjResultMap.get(courseC);
            list.add(courseThatDependsonCourseC);
            adjResultMap.put(courseC,list);
            
            
         
            
            
        }
        
        return adjResultMap;
        
        
        
    }
}


//Small modification
//when we are incrementing counter, we ll add values to result array 


int currentCourse = q.poll();
counter++;  

||
initialize k  =0;

int currentCourse = q.poll();
result[k++] = currentCourse;



and 
return counter == numCourses;

||

if(counter == numCourses){
    return result;
} // wehich means we already completed all course
 else{
     return new int[] {};
 }


 and 

 int[] result = new int[numCourses];
        
 if(prerequisites.length == 0){
     for(int i=0; i<numCourses; i++)
         result[i]=i;
     return result;
         
 }
