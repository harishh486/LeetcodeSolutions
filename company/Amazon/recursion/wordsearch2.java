class Solution {
    
    
    
    class TrieNode{
        TrieNode[] children;
        String word;
        public TrieNode(){
            children = new TrieNode[26];
            word = null;
            
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        
        // word search problem
        // Seeing this would definitely bfs/dfs
        // matrix pattern
        
        //Many words:: take each word and try. to search in the matriz juts like word search
        //But the time complexity would be very high
        
        // We can leverage Trie data structure
           // -- prune. the back tracking.
           //     we ll try to. iterate whole matrix and if that board[i][j] char is  
           //         found in Trienode '0' which is a children for root, then we ll keep searching
           //             if we have whole word in matrrix 
           //                 --back tracking with trie --pruning
        
        // we need a result
        List<String> result = new ArrayList();
        
        //base case
        if(board == null  || board.length ==0)
            return result;
        TrieNode root = new TrieNode();
        
        buildTrie(root, words);
        
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[0].length;j++){
                char c =  board[i][j] ;
                // since it stores only relative numbers
                // if root.chilren --> is not null wehich means we find the first char and now we do dfs if whole string is contained in the child
                if(root.children[c-'a'] != null)
                    dfs(board, i,  j, root , result);
            }
        }
        return result;
        
        
    }
    
    // we need the position of that and check around if we have whole string in that
    
    public void dfs(char[][] board, int i, int j, TrieNode curr , List<String> result){
        
        //boundaries
        if(i<0 || i>= board.length || j<0 || j>=board[0].length) 
            return ;
       if(board[i][j] == ' ') // if i do this , we ll avoid duplicates
           return; // we ll do this becoa we dont want to process
        
        char c = board[i][j];
        if(curr.children[c -'a'] == null) // if this is null we dont have anything in child
            return ;
        
        curr = curr.children[c-'a'];
        if(curr.word!= null){
            //we found a word in trie and we add result
           // finally we traverse till null node and we shud add them to result
            result.add(curr.word);
            curr.word = null; // we do not want to add duplicates to our results
            
            
        }
        
        // we ll try to process this character now 
        // first set it as ' ' and it will make it as we have visited this already in dfs
        
        board[i][j] = ' ';
        // do dfs with nodes 
        dfs(board,  i+1,  j,  curr , result);
         dfs(board,  i-1,  j,  curr , result);
         dfs(board,  i,  j+1,  curr , result);
         dfs(board,  i,  j-1,  curr , result);
        // do not miss reseting to original in back tracking
        
        board[i][j] = c;
        
        
        
        
    }
    
    public void buildTrie(TrieNode root, String[] words){
        for( String s : words){
            TrieNode cur = root;
            for(char c : s.toCharArray()){
                int index = (int)(c-'a');
                if(cur.children[index] == null)
                   cur.children[index] = new TrieNode();
                
                cur = cur.children[index];
            }
            
            cur.word = s;   
        }
        
        
    }
}


// Back Track technique:

// Make chnage
// reucrsive

// and undo the chnages


iterate over the ,matriz 
each letter and check with trie whether that letter is present in the trie or not
if so then control comes to second char in that node trie , now matrrix do dfs and search
 if any sorrounding  element is  a char  item that is present in the  next node of the trie
 if so repeat
