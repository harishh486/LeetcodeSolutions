class Solution {
    public int myAtoi(String str) {
        //2. Trim the string
        str =  str.trim();
        // null check
        if( str == null || str.length() <=0 )
            return 0 ;
        
        boolean isNegative = false;
        
        double result = 0;
        
        int startIndex = 0;
        
        if(str.charAt(0) == '+' || str.charAt(0) == '-')
            startIndex++;
        
        if(str.charAt(0) == '-')
            isNegative = true;
        
        for (int i = startIndex; i< str.length(); i++ ){
            
            //non numeric characters
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            
            int digitvalue = str.charAt(i) -'0';  // str version of '9' - str version of '0 gives a digit difference'
            result = result*10 + digitvalue;
        }
        
        if(isNegative)
            result = -result;
        
        if(result < Integer.MIN_VALUE)
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
