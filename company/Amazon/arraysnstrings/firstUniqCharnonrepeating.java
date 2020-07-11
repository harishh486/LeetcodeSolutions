class Solution {
    public int firstUniqChar(String s) {
        
     // first we need a character count of each character in a stroing, no matter what we need to travesre entire string
        //HashMap
        HashMap<Character, Integer>  hm = new HashMap();
        
        for (int i=0; i< s.length();i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0) +1);
        }
        
        for (int i=0; i<s.length(); i++){
            if(hm.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
        
    }
}


// Build hashmap 
// and traverse the hashmap with value ==1 then return index

// Time O(N) since we go through the string of length N two times.
// Space O(1) 0(n) ~0(26) alphabets ~ 0(1)  constant time