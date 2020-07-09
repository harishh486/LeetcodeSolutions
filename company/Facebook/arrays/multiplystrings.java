class Solution {
    public String multiply(String num1, String num2) {
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        int total = len1+len2; //total lenth
        
        
        int[] final1 = new int[total];
        
        
        for (int i = len1-1 ; i>=0; i--){
            for (int j= len2-1; j>=0; j--){
               
                int mul = (num1.charAt(i) - '0' )*(num2.charAt(j) - '0'); //conversion : remem '0'
                int p1 = i+j;
                int p2 = i+j+1;
                // Multiply with current digit of first number 
               //# and add result to previously stored result 
                //at current position.)
                int sum = mul + final1[p2];
                final1[p1] += sum/10; //most critical step to add
                final1[p2] = sum%10;
                
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for (int p=0;p <final1.length;p++){
            if(! (sb.length() == 0 && final1[p]== 0  ))
                sb.append(final1[p]);
        }
        
        return sb.length() ==0 ? "0" : sb.toString();
        
        
    }
}

// for strings use length() and for arrays use length like int [], double  [] etc
//0(m*n) -time
// spacre 0(m+n)
//num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]
// Multiply with current digit of first number 
//# and add result to previously stored result 
//at current position.)