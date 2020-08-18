class Solution {
    
    
    //we ll maintain two instance variable one for longest length and longest strstrat
      int longestPalindromeLength=0;
      int longestPalindromeStartIndex;
  
  public String longestPalindrome(String s) {
      
      // brute force take each letter and for each letter generate palindrome-o(n2)
      // then take the longest out of those--brute force--n3
      
      // 2 situations
      // aba and abba , one is. mid and other is non mid but both are palindromes/
      // instead of first and last ptr thing, we go to middle and traverse back left and right like we goto mid and expand latter.
      
      
      if(s == null || s.length() < 1)
          return "";
      if(s.length() == 1){
          return s;
      }
      // then we traverse thru the list and treate every index as midpints and check if that is midpoint and forms a palindrom with taht midpoint and caluclta ethe length if it suceeds.
      
      for(int i=0; i< s.length(); i++){
          // check two cases mid and non mid for every charcater
          expandFromMiddle(s, i, i); //mid
          expandFromMiddle(s, i, i+1); // non mid
          
      }
      
      
      // once the loop determines for every char we have max length and from where we can start
      //use substring
      return s.substring(longestPalindromeStartIndex, longestPalindromeStartIndex + longestPalindromeLength);
      //substring is (inclusive, exclusive)
      
  }
  
   private void expandFromMiddle(String s, int left, int right){
      
      // check boundaries and also palindrome
      while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
          left--; // <----- this direction
          right++; //----- > this way
      }
      
      if(longestPalindromeLength < right-left-1){
          longestPalindromeLength = right-left-1 ; // aba //here after loop l =-1 and r = 3 ==>3--1 -1 ==3 which is palindrom lenhth
          longestPalindromeStartIndex = left +1 ;  // since we reduced l-- in upper step and now we do increase one
          
      }
      
      
      
  }
}

// Optimized than dp approach

// t: o(n^2
// s: 0(1)

// but in dp both are o(n^2)

// Use Expand from middle approach instead of dp

// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.