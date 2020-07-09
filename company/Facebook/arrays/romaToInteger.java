class Solution {
    public int romanToInt(String s) {
        
        if( s == null || s.length() == 0)
            return 0;
        
        Map<Character, Integer> romanMap = new HashMap<>();
        
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        // string opertaion move from right to left side  <-------
        
        //leave the last one which is null
        
        int result = romanMap.get(s.charAt(s.length() - 1));
        
        for (int i = s.length() - 2 ; i>= 0; i--){
            
            if(romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i +1))){
                result = result + romanMap.get(s.charAt(i));
            }
            else{
                result = result - romanMap.get(s.charAt(i));
            }
        }
        
        return result; 
        
    }
}
      |      
0  01234
//"LVIII" 58 L = 50, V= 5, III = 3.

//T:0(n)
//S:0( n)
// Use a dict map to store values of roman to int map
// main logic is traverse from right to left, if ith  and i+1th value is  i< i+1 like I V which is special case so we need to subtarct from i=1 value to ith value
// else VI add thr result of i+1 with ith value
// < -->minus
//> = -->add 