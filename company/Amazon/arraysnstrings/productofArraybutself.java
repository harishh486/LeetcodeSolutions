class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int N = nums.length;
        int outerProduct[] = new int[N];
        outerProduct[0]=1;
        // strt from first index  becos we need prod of curr element before that
        
        for(int i=1; i< N;i++){
            outerProduct[i] = outerProduct[i-1]* nums[i-1]; 
        }

        //

        int R=1;
         for(int i=N-1; i>=0;i--){
             // out = left (i.e)out[i] * R
            outerProduct[i] = outerProduct[i]* R;
            R= R* nums[i];    
        }

        
        return outerProduct;
        
        
        
    }
}

// 
// Time complexity : O(N) one iteration to construct the array LL, 
// Space complexity : O(1)since don't use any additional array for our computations. 

//Basically u need to multiply left and right of the current element
// so inorder to get a current  left product and right product  do the math

// initialize the left most index  to 1  and do a left product already calculated * nums[i-1]

// in order ot miantian single array we use temp variable as R  and R value initially as 1
// and R goes to R*  nums[i]
// out product = left prdouct *R



class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int N = nums.length;
        
        int leftProduct[] = new int[N];
        int rightProduct[] = new int[N];
        
        int outerProduct[] = new int[N];
        
        leftProduct[0]=1;
        rightProduct[N-1]=1;
        // strt from first index  becos we need prod of curr element before that
        
        for(int i=1; i< N;i++){
            leftProduct[i] = leftProduct[i-1]* nums[i-1];
            
        }
         for(int i=N-2; i>=0;i--){
            rightProduct[i] = rightProduct[i+1]* nums[i+1];
              
        }
        
         for(int i=0; i< N;i++){
            outerProduct[i] = leftProduct[i]* rightProduct[i];
            
        }
        
        return outerProduct;
        
        
        
    }
}

