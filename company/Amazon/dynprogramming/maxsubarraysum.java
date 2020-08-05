class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length ==0)
            return 0;
        
        // [-2,1,-3,4,-1,2,1,-5,4], we ll iterate thru the the loop and we ll keep track of 
        // maxSubArray_Sum and 
        // maxSum_including_current 
        
        int maxSubArray_Sum = nums[0]; 
        int maxSum_including_current = nums[0];
        
        // since we already processed 0 , start with 1 index
        for(int i=1; i< nums.length;i++){
            maxSum_including_current = Math.max(nums[i], nums[i] + maxSum_including_current);
            maxSubArray_Sum = Math.max(maxSubArray_Sum,maxSum_including_current );
            
        }
        
        return maxSubArray_Sum;
        
        
    }
}


// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.


// Here  we maintain two variables  one
// is maxsubaarrySum and maxsumincluding current element
// here we ll take the maxsumcurrentelemnt only if we get good value with previous ones

// example 

// -2 1
// max current sum initally =-2 
// next max sum current = max(max current sum initally  + nums[i], nums[i])
//                      = max(-2+1, 1)

// and max sumarray will be iniyially -2 but as we prolong and traverse if, max sum current is greater than already sum , then we update the final max
// and return the final max

// // T:  o(n)
// // S: 0(1)