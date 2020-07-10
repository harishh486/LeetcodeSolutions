class Solution {
    public String minWindow(String s, String t) {
        
        if( s == null || t == null)
            return "";
        
        
        String res = "";
        int[] letterCount = new int[128]; // which holds all count array of both strings

        int count = 0, left = 0, minlen = Integer.MAX_VALUE;
        //two ptrs but both start at same place


         // initialize the charACount of t array
        // first convert str to charArray
        for (char c : t.toCharArray() )
            ++letterCount[c];// store only t array to compare
        for (int right= 0; right< s.length(); ++right){
            // meaning there is a letter of s which is in t, so increse the count
            // remember thhis step it applies not only to left char but also right characters in string s thats why it goes negativ
            if( --letterCount[s.charAt(right)] >= 0)
                ++count;//  ifwe reduce the count array with the correct index and still if > 0 which means that char is part of t array so increase the count
                //that it found one letter which is in t
            while(count == t.length()){ // when count==t.length which means it matches exact length
                if(minlen > right-left+1){
                    minlen = right-left+1;
                    res = s.substring(left, right+1);   //s.substring(inclusive, exclusiveindex)
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


//everythhing in charArray is initilaized to -1;

// T: 0[s+t] -- every element in s touched atmmost twice and t - build hash table
// s:0[s+t] --we need to store all the window for both strings


// two pts:

// sliding minWindow
// 2 pts startss at same 
// L R e

// xpand the window by R++ if not satified

// once satified incremnet L by forwarding

// as soon as it fails the requiremnt again R++ until satified
 

