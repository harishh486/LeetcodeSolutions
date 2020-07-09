class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r = 0 ;
        int max = 0;
        
        if (s.length()==0 || s== null){
            return 0;
            
        }
        
        Set<Character> set = new HashSet<>();
        
        while(r< s.length()){
            if(set.add(s.charAt(r))){
                r++;
                max = Math.max( max, r-l);
                
            }
            else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
        
    }
}

//sliding window concept

// Accepted 
//T: 0(n)--traverse thru all char
// S: 0[1]--DS storage is atmost 26 characters so o(26)----O(1)