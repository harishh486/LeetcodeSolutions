class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        
       // loop thru and make transpose
        // also j<i becos u need to move along with rows so very important
        
        for(int i=0 ; i< N; i++){
            
            // j=i  and j<N as we need to move along with rows
            for (int j=i;j<N;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i]= temp;
            }
        }//iterate thru all rows so N here
         for (int i=0 ; i <N; i++){
             //we need not iterate thru all colu, we can go upto N/2
             
             for(int j =0;j<(N/2);j++){
                 //here we are manipulating same row so keep i constant only j logic will change
                 int temp = matrix[i][j];
                 matrix[i][j]= matrix[i][N-1-j];
                 matrix[i][N-1-j] = temp;
             }
             
         }
        
        
    }
}

// T: 0(n*m) linear some or 0(n2) --best case efficient
// S:0[1]

First find the matrix length
//2 loop regular with inner loop shud follow outre loop row i=0 outer andinner j=i inner loop
//replace matrix i,j with matrix j,i with temp

// once transpose is completed
// then use reverse the values within row 
// so i<N but inner j<N/2 since half is enugh
 reverse loop  i shud be constant in logic since it moves with rows but 
 j logic will be chnaged as j ==> N-1-j
 0 1 2
 j=0
 3-1-0=2
 j=1
 3-1-1=1
