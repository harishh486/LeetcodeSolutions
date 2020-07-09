/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        
        int len = 0;
        
        for (int i=0;i<n; i+=4){
            
            
            char[] temp = new char[4]; //temp array for storing whatever we read till now
            len = read4(temp);
            
            System.arraycopy(temp,0,buf, i, Math.min(len, n-i)); //Min of wht had read in this iteration to copy and How many yet to be read (total- already read)
            if(len<4){
                return Math.min(n,i+len); // min of total characters originally to be read, and what charcaters had read till now 
                //Math.min(count, n-total) is because we only want to read N characters even if we have all 4 characters returned from Read4
            }
            
        }
        return n; //modulus of 4 mening read all
        
    }
}


// T:0(n)
// S:0(n)
//  for loop i+=4 important aspect
//  len shud be outside loop to carry originally value
//  arraycopy(source, source index, dest, dest indx, total len to copy)
//  while copu Min(len, n-i)
//  ifl <4 min(n, i+len)

 //Imp: At the end return n;