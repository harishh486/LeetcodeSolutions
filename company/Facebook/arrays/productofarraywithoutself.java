class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int N = nums.length;
        
        int[] outer_arr = new int[N];
        
        outer_arr[0] = 1;
        for (int i =1 ; i< N ; i++){
            outer_arr[i] = outer_arr[i-1]*nums[i-1];
        }
        
        int R =1;
        for(int i = N-1; i>=0 ; i--){
            outer_arr[i] = outer_arr[i] * R;
            R = R * nums[i];
        }
        return outer_arr;
    }
}


// the output array does not count as extra since we need to return so we can use one output array


// Input:  [1,2,3,4]
// Output: [24,12,8,6]

// 1 2 3 4

// f = 1 1 2 6
// s = 24  12   4 1

// o = 24 12 8 6 

// single array 

//  o = 1 1 2 6 


//  Take care of R = R* nums[i]