class Solution {
    public String addBinary(String a, String b) {
        // 11
        //  1
        int i = a.length()-1;
        int j = b.length()-1;
        int carry=0;
        
        
        StringBuilder sb = new StringBuilder();
        
        while(i>=0 || j>=0){
            //convert string to integer
            int sum = carry;
            
            if(i>=0){
                sum+= a.charAt(i)-'0';
            }
            if(j>=0){
                sum+= b.charAt(j)-'0';
            }
            sb.insert(0, sum%2);
            carry= sum/2;
            
            i--;
            j--;
            
        }
        if(carry>0){
            sb.insert(0,1);
        }
        
        return sb.toString();
        
    }
}


// T:0(Max(m,n)) where NN and MM are lengths of the input strings a and b.

// T:0(Max(m,n))  to keep the answer.

// Algorithm

// Convert a and b into integers x and y, x will be used to keep an answer, and y for the carry.

// While carry is nonzero: y != 0:

// Current answer without carry is XOR of x and y: answer = x^y.

// Current carry is left-shifted AND of x and y: carry = (x & y) << 1.

// Job is done, prepare the next loop: x = answer, y = carry.

// Return x in the binary form.


//int(string, base)--->Returns an integer value, which is equivalent 
//of binary string in the given base. 
class Solution:
    def addBinary(self, a, b) -> str:
        x, y = int(a, 2), int(b, 2)
        while y:
            answer = x ^ y
            carry = (x & y) << 1
            x, y = answer, carry
        return bin(x)[2:]

       // bin(a) a : an integer to convert
// Return Value :
// A binary string of an integer or int object.

T:  O(N+M), where NN and MM are lengths of the input strings a and b.

Space: O(max(N,M)) to keep the answer.