class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int i =0 ;
        while( i < s.length() && i < t.length()){   // Strict while check

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if( c1 != c2){   //check if both char are not matching then do some operation
                // no we have replace, add, insert
                return s.substring(i+1).equals(t.substring(i+1)) ||  //replace
                       s.substring(i).equals(t.substring(i+1)) ||     //add
                    s.substring(i+1).equals(t.substring(i));         // del w.r.t fisrt string
                       
                
            }
            i++; //if both same dont do anything just increment
            
        }
        return Math.abs(s.length() - t.length()) == 1; //if lengths are one edit distance adn till now they are case in all char. then check distance adn return true or false
    }
}



//min edit distance
//class dp problem
// T: 0(max(m,n)
//levenshtein distance dynamic programming
// Strict while check
//check if both char are not matching then do some operation
//if both same dont do anything just increment
//if lengths are one edit distance adn till now they are case in all char. then check distance adn return true or false
