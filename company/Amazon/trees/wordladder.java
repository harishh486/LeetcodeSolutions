
// What is being asked

// start to end transformation in a minimum distance possible
// shortest path from start word to end word

// do we need return to minPath length or possible paths  
// Since we know that we need a path from one pt to other point and we need apath
// so we are searching some path--seqrching problem

// --bfs and dfs
// minimum shorthpath =  since i need a shortest path, how can i use bfs to find a shortest path
// bfs -- is great when we want to find shortest path length and not the path
// or if the pathh exists


// dfs - is great when we 
// 1. esier to implement --generic
// 2. and u r not looking for shortest path but when u want to find the path itself

// great when u recreate the paths


// Here bfs

// here use  try with bfs

// create a graph where start is starting node and use the nodes given in dict to use as intermediate hops and reach final word

// once u create a pth then u need to find the length of th path in shortest distance

// How to create that graph??

// func search(sta)rt, end,List<List<String>>

// findadjacent()


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        
        // convert list to set since we can easily search within set using contains
        Set<String> set = new HashSet(wordList);
        
        // base condition since if its not presnt return 0
        
        if(! set.contains(endWord))
            return 0;
        // what is asked --shortest path from start word to end word
        // shortest distanc between two nodes in a graph --
        //dfs or bfs
       // use Queue
        
        Queue <String> q = new LinkedList();
        q.offer(beginWord);
        
        // shortest path 
        int result = 0;
        
        
        while(!q.isEmpty()){
            
            //level by level
            for(int i=q.size();i>0;i--){
                //int i =0; i<q.size(); i++
                //int i=q.size();i>0;i--
                // take the string
                String currentWord = q.poll();
                if(currentWord.equals(endWord))
                    return result +1;
                
             
                
                for(int j=0; j<currentWord.length(); j++){
                       // now we need to manipulate the string
                    char[] charArray = currentWord.toCharArray();
                    for(char c='a';c<='z';c++){
                        charArray[j] = c;
                        String newStr = new String(charArray);
                        if(set.contains(newStr) && ! newStr.equals(currentWord)){
                            //push to queue as it might be the chnace to disver the other neighbours
                            q.offer(newStr);
                            //aslo remove this string from set as we can remove duplicates of visits within set
                            set.remove(newStr);
                        }
                    }
                }
                   
            }
            
            result++;
            
            
        }
        return 0;
        
    }
}


// similar to bfs problem 
// 1. pop
// 2. oprate 

//    take th current string and convert to charArray
//    and try to find all possible versions of words with other al;phabetrs and check if that number is in set and if so , then add
//    mean while to brealk  if the string we find during q, has met endword then return result+1;

// // 3. push
//     // pus th found word and also remove that pushed word from set so that it avoids duplicates

//     for some reason standard queu strycture was not working for some test cases for loop===check on this

            
    // while(!q.isEmpty()){
            
    //     //level by level
    //     for(int i=q.size();i>0;i--){
    //         //int i =0; i<q.size(); i++
    //         //int i=q.size();i>0;i--
    //         // take the string
    


    // T: 0(L*N)  // l- avg length of word and n is the no of words

    // Space  0(n) --queu space

                          
                           


