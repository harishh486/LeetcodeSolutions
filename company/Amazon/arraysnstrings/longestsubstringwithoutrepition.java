class Solution {
    public int lengthOfLongestSubstring(String s) {
        
       if(s.length() == 0 || s == null)
           return 0;
        int l=0;
        int r=0;
        int max=0;
        
        HashSet< Character> hs = new HashSet();
        
        //sliding window always check with right ptr with max length
        while(r<s.length()){
            
            if(! hs.contains(s.charAt(r))){
                hs.add(s.charAt(r));
                max = Math.max(max, hs.size());
                //since it has uniques set we can take size of has set
                r++;
            }else{
                hs.remove(s.charAt(l));
                l++;
            }
            
        }
        return max;
        
    }
}

// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3.

//sliding window
fix one rotate other , 
T: 0(n) to all charAt
S:  0(m) - size of has set , total number of elemenets in hashset 
0(26) --0(1)