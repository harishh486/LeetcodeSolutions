class Solution {
    public List<String> letterCombinations(String digits) {
        
        // combination -- tells permutation
        // heavy recursion
        // helper function standard template
        
        List<String> result = new ArrayList();
        
        // Have a Digit array just to grab the letters from pressed didgits
        String[] mapping = {"","", "abc","def"  , "ghi" ,"jkl", "mno","pqrs","tuv","wxyz"};
        
        if(digits == null || digits.length() == 0)
            return result;
        
        letterCombinationsRecursive(mapping, result, digits, "", 0);
        return result; 
        
    }
    
    private void letterCombinationsRecursive(String[] mapping, List<String> result, String digits, String combination, int index ){
        
        // base case
        // "23" --> index 0 and index 1, 
        // when we reach the index , we already had a combination of two letters so we can directly add them
        
        if(index == digits.length()){
            result.add(combination);
            return ;
        }
        
        // Parse the string "23" to actual digits and then get actual letters of that digits 2 and 3;
           // iterate upto digit length
        // traverse heavy recursive method till how many numbers
            // get the actual letter and iterate ovetr th lengthy of that letter
        
          // here lets say we got "abc"
            // then we add the first letter of letters into existing combination and increase the index to go to next pressed number.
                
            // take 'a' - call other numbers "3"--return def
            // now recursive call again
        
        char[] pressedNumbers = digits.toCharArray();
      
        String letters  = mapping[pressedNumbers[index]- '0'];
        //a- ad-ae-af, b-bd-bf-be;;;etc
        for(int i =0; i< letters.length();i++){
            System.out.println(" " + combination);
            System.out.println(" " + combination + letters.charAt(i));
            
            letterCombinationsRecursive(mapping, result, digits, combination + letters.charAt(i) ,index+1 );
                  
            
        }
        
    }
}


T: O(3 ^N × 4^M) 

where 'n' is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) 
and 'm' is the number of digits in the input that maps to 4 letters (e.g. 7, 9), 
and 'n+m' is the total number digits in the input.

S: O(3 ^N × 4^M) 

since one has to keep all possible solutions andf it will have that many call stacks
