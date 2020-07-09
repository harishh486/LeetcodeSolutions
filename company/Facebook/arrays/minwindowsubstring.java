class Solution {
    public String minWindow(String s, String t) {
        
        if( s == null || t == null)
            return "";
        
        
        String res = "";
        int[] letterCount = new int[128]; // which holds all count array of both strings

        int count = 0, left = 0, minlen = Integer.MAX_VALUE;
        for (char c : t.toCharArray() )
            ++letterCount[c];// store only t array to compare
        for (int right= 0; right< s.length(); ++right){
            if( --letterCount[s.charAt(right)] >= 0)
                ++count;//  ifwe reduce the count array with the correct index and still if > 0 which means that char is part of t array so increase the count
                //that it found one letter which is in t
            while(count == t.length()){ // when count==t.length which means it matches exact length
                if(minlen > right-left+1){
                    minlen = right-left+1;
                    res = s.substring(left, right+1); 
                }
                if(++letterCount[s.charAt(left)] > 0)// reduce the legnth if necessary by increasing the left position
                    --count; //decrement count becos the lettercount [left after increasiing  and > 0 which means that char is part of t array and we are moving that usig left so decrement the count]
                left++; // the reason aftr increment , if its not t arrat char, then it wud be from s which was just 0 and never greater than 0
            }
            
        }
        
      
        return res;
        
        
    }
}

//initalsi all 0's

// T: 0[s+t]
// s:0[s+t]
