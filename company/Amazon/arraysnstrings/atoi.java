class Solution {
    public int myAtoi(String str) {
        // break down the question
        
        
        //  trim
        //  convert logiic
        // negative number make a note of it and convert the rest
        // convert the string and if it finds non numeric  return 0
        // non numeric or not a =/- no conversion
        // if result is out of range then print max or min
        // +/- takes them and do conversion then add sign
        // if the first char after trimming is +/- increment the index and carry out the logic//make a note of negative

        
        str = str.trim(); //trim case
        
        if( str.length() ==0 || str == null)
            return 0;
        
        double result = 0; //since big numbers
        
        
        boolean isNegative = false; // to note if its a negative number
        
        int startIndex = 0;
        
        if(str.charAt(0) == '+' || str.charAt(startIndex) == '-'  )
            //forward and ignore and later add sign
            startIndex++;
        
        if(str.charAt(0) == '-'  )
            isNegative = true;
        
        
        for (int i= startIndex; i < str.length(); i++){
            if( str.charAt(i) < '0' || str.charAt(i) > '9')
                break; // starts with non numeric "word123"
            
            int digit = str.charAt(i)-'0';
            result = result*10 + digit;
            
        }
     
        if ( isNegative) // negative case
            result = -result;
        
        if(result < Integer.MIN_VALUE)  //out of bound case
            return Integer.MIN_VALUE;
        
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        

        
        return (int)result;
        
            
        
        
    }
}



// null check
//trim case using trim()
// non numeric values -break and return
//negative---have a flag and return with -
//starts with non numeric --return break from loop and return 0
// num--convert and return
//underflow and overflow using Integer.MAX_VALUE and min
//0(n)--time and 0(1)-space no stoarge ds
// str.charAt(i)
//ascii '1' -'0' = 0
//ascii '9' - '0' = 9
// ascii 'a' - '0' does not fall in between 0-9 95-48 something like that
//"324\0" - > 0*10 + 3=>3 ; 3*10 + 2 = 32; 32*10 + 4 =324