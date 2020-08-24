--\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
class Solution {
    public int trap(int[] height) {
//         Input:    [0,1,0,2,1,0,1,3,2,1,2,1]
        
//         leftarr = [0,0,1,1,2,2,2,2,3,3,3,3] 
            
//         righarr = [3,3,3,3,3,3,2,2,2,1,0,0]
            
//             logic = min(left[i],right[i]]) - input[1]
//             result= 0
            
        if(height.length== 0)
            return 0;
        
        int left[]= new int[height.length]; // left max array at ith index
        int rightMax =0; 
        int water = 0;
        
        
        left[0]=0;
        
         //leftarr = [0,0,1,1,2,2,2,2,3,3,3,3] 
        // now we build the left max array.. check the current element and see if we have largest element till now
        //that till now what can u see the tallest from this index
        for(int i=1; i<height.length; i++){
            left[i] = Math.max(left[i-1], height[i-1]); 
        }
        
        for(int j= height.length-2; j>=0; j--){
            rightMax = Math.max(rightMax, height[j+1]);
            if(((Math.min(rightMax, left[j])) - height[j]) > 0){
                water = water + (Math.min(rightMax, left[j])) - height[j];
            }
        }
        return water;
        
        
    }
}


//T:0(n)
//S:0(n)

// but we can take 2 pts approach and can reduce the space in 0(1)


// Logic:

// Patter observe here:
// check the left  max and right  max w.r.t current index, u ll know the left and right max, 
// then take the minimum out of those and subtract the index[i]

// Build a leftMax array = left[0]= 0 and fil the array 
// logic to fill the array is 

// if ur at index i, look at the leftMax till i-1 and the current index[i-1] and get the max out of both

// for int=1 
// leftArray[i] = leftArray[i-1]+ height[i-1];

// Build the same right most array but we can calculate the right most value in ongoing fashion since we have left most array already

// for int j=hieght-2; j>=0;j--
// right = MAx(h[j+1), right)
// then x =min(left[j], right) - h[j];

// if x>0
//  then add that to water = water+x;