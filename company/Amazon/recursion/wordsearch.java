class Solution {
    public boolean exist(char[][] board, String word) {
        
    // standard recursive matrix problem
        
        if(board.length == 0 || word == null || word.length() == 0)
            return false;
        
        for(int i =0; i<board.length;i++ ){
            for(int j=0;j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, 0,i, j))
                    return true;
            }
        }
        
        return false;
        
    }
    
    boolean dfs(char[][] board, String word, int count, int i, int j){
        // base condition
        //we will increent count for every recursive call
        if(count == word.length()){
            return true;
        }
        
        if(i<0 || j<0 ||i >= board.length || j >= board[0].length || board[i][j] != word.charAt(count))
            return false;
        
        char temp=board[i][j]; //restore original 
        //chnage to something becos of avoiding visiting again 
        board[i][j] = ' ';
        boolean found = dfs(board, word, count+1,i+1, j) || dfs(board, word, count+1,i-1, j) || dfs(board, word, count+1,i, j+1) || dfs(board, word, count+1,i, j-1) ;
        board[i][j] = temp;
        return found;
        
    }
}



T: O(N⋅4^L)
where N is the number of cells in the board and
 L is the length of the word to be matched.

For the backtracking function, 
its execution trace would be visualized as a 4-ary tree, 
each of the branches represent a potential exploration in the corresponding direction.
 Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 4-nary tree,
  which is about 4^L4 

 .

We iterate through the board for backtracking, 
i.e. there could be NN times invocation for the backtracking function in the worst case.



The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. 
Therefore, the space O(L).==>is the length of the word to be matched.