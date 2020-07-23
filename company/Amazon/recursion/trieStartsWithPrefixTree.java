class Trie {

    // HashMap<Character,Trie> children;
    // String word;
    
    Trie[] children;
    boolean isWord;
    
    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isWord = false;
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie curr = this;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new Trie();
            curr = curr.children[c-'a'];
        }
        curr.isWord = true;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        
        for(char c : word.toCharArray()){
            curr = curr.children[c-'a'];
            if(curr == null)
                return false;
  
        }
        if(curr.isWord == true)
            return true;
        return false;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
       Trie curr = this;
        
        for(char c : prefix.toCharArray()){
            curr = curr.children[c-'a'];
            if(curr == null)
                return false;
  
        }
        return true;
        
    }
}


T: 0(M)  for search it takes order of m length

S:0(M) 
// Prefix tree: -- in order to search any word in dictionary
// Retrieval

// Having map here is a really advantage which saves space instead of all 26 char spaces


//trie
// run
// runt
// runs
//    r
//    u
//    n
//   t  s
  
//   efficient storing--compressed
//   dictionary algorithm
//   give me a word and check if it is present in dictionary
  

  
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */