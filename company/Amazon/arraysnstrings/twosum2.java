
//Two Sum II - Input array is sorted
// Input: numbers = [2,7,11,15], target = 9
// Output: [1,2]


class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Always think of  2 ptrs when u see sorted array
        // important technique
        
        int a_ptr = 0;
        int b_ptr = nums.length-1;
        
        //[2, 7, 11, 15] --ask if sorted
        
        while(a_ptr <= b_ptr){
            int sum = nums[a_ptr] + nums[b_ptr];
            
            if(sum > target){
                b_ptr -=1;
                
                
            }else if(sum < target) {
                a_ptr += 1;
            }
            else {
                return new int[]{a_ptr +1, b_ptr+1};
            }
        }
        
        return new int[]{a_ptr +1, b_ptr+1};
        
        
        
    }
}


// here we use imp techniq
// use two pointer if we have sorted 
// iterate over both pts and check if sum is ><= target , depnds on that adjust ptr indeex

// t: o(n)
// s:0(1)