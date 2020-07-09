class Solution {
    public int strStr(String haystack, String needle) {
        // what needs to return if needle is empty string --Ask question
        
        if(needle.isEmpty()) return 0;
        
        if(needle.length() ==0 || needle == null)
            return -1;
        
        if(haystack.length() < needle.length())
            return -1;
        
        // we will traverse only till the difference of both string orelse we are wasting time
        for (int i=0; i<= haystack.length()-needle.length(); i++) {
            for (int j=0; j< needle.length() && haystack.charAt(i+j) == needle.charAt(j); j++){
                if(j== needle.length()-1)
                    return i;
                
            }
            
        }
        return -1;
        
    }
}

// can be optimized using KMP algorithm 
//T: 0mn
//S: 0(!). but can be improved time by using Rabin-Karp or KMP algorithms.where we use space 0(n)


// brute force
//compare all charcter in string 1 to all characters in string j maintain the difference: though m-n becos of no use further
//can be optimized using KMP 

//KMP can be optimized using 0(m+n)
 //and space 0(m)

