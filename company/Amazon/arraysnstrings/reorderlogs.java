class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // write a diff custom sort order
        Arrays.sort(logs,(log1, log2) -> {
        
            String s1[] = log1.split(" ",2); // split atmost 2 words
            String s2[] = log2.split(" ",2);
            
            boolean islog1Digit = Character.isDigit(s1[1].charAt(0));
            boolean islog2Digit = Character.isDigit(s2[1].charAt(0));
            
            if(!islog1Digit && !islog2Digit ){
                int comparison = s1[1].compareTo(s2[1]);
                if (comparison != 0)
                    return comparison;
                return s1[0].compareTo(s2[0]);
                
            }
             return islog1Digit ? (islog2Digit ? 0 : 1) : -1;
            
        });
        
        return logs;    

        
    }
}

//just default sorting order has to chnage according to ur condition


//sort order //mostly nlogn
// T: nlogn
// s: o(n)