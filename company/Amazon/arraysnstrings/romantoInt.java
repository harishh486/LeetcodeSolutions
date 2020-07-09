class Solution {
    public int romanToInt(String s) {
        
        if( s.length() ==0 || s == null)
            return 0;
        
        //Initialize the map with regular roman and int values
        HashMap< Character, Integer> hm= new HashMap();
        hm.put('I',1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
         hm.put('D', 500);
         hm.put('M', 1000);
        
        int result = hm.get(s.charAt(s.length()-1));
        //keep the result initial value to righ most digit and get original value from map
        // make the result as last number for the sake. of iitial number
        

        //traverse from right to left
        for( int i= s.length()-1; i>0; i--){
            if(hm.get(s.charAt(i-1)) >= hm.get(s.charAt(i)))
                result=result + hm.get(s.charAt(i-1));
            else
                result = result - hm.get(s.charAt(i-1));
            
        }
        return result;
        
    }
}


//"LVIII" 58 L = 50, V= 5, III = 3.

//T:0(n)
//S:0(n)
// Use a dict map to store values of roman to int map
// *** keep the result initial value to righ most digit and get original value from map

// main logic is traverse from right to left, if ith  and i+1th value is  i< i+1 like I V which is special case so we need to subtarct from i=1 value to ith value
// else VI add thr result of i+1 with ith value
// < -->minus
// >= -->add 
// u can use i-1 n i indeex depends on ur logic
