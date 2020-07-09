class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        if(s == null || s.length() ==0)
            return 0;
        
        int l=0, r=0, distinct = 0, maxlen=0;
        //sliding window 
        
       // keep track of characters in hashmap or map array
        int[] map = new int[256];
        for(;r< s.length();r++){
            //loop thru right pointer as sliding window
            //iterate array once
            
            //check if element is present in map, if not distnct++ becos its new elemnt
            if(map[s.charAt(r)] == 0)
                distinct++;
            map[s.charAt(r)]++; // increment the value of the map array at corresponding array
            // check if disntinct is not crossing k becos of atmost
            
            while(distinct > k){
                //we need to do something like
               // reduce the map at char l and inc left
                map[s.charAt(l)]--;
                if(map[s.charAt(l)] == 0) distinct--;
                //there may be more characters we need to get down all
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
            //returm max len, sliding window length
        }
        return maxlen;
        
        
    }
}


// T:0(n)