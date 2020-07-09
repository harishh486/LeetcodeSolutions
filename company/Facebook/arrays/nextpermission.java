class Solution {
    public void nextPermutation(int[] nums) {
        
        // if (nums == null || nums.length == 0)
        //     return;
        
        int i = nums.length -2;
        // since we took l-2, which is last index-1 //bcos comparing i , i+1
        
        while(i>= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        // if not just descending like regular input
        if(i >= 0){
            int j = nums.length - 1;
            
            while(j >=0 && nums[i] >= nums[j]){
                j--;
            }
            //get the next just highest num from the rest of the array and swap it swapth index
            swap(nums, i, j);
            
        }
        //if descending, u need to make ascending...abnormal testcase
        //reverse the array from next position of the swap index
        reverse(nums, i+1);
        
    }
    private void swap(int nums[], int i, int j){

        // replace swap with correct thing
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int nums[], int start){
        int p = start;
        int q = nums.length -1;
        
        while(p<q){
            swap(nums, p, q);
            p++;
            q--;
        }
    }
}

//Accepted
// SO basically start with end index, compare the right index to its immediate unti descending is not the case 
//once u encounter ascending, stire the index...thats the index we need to swap
//once u get the index that need to swap, u need to find out other index to swap with from the array.
//u ll get the second swap index doing compare the 1st swap index value with rest of the array from right most so that it shud be just higher than the
//first index
//at this point u ll get i, j to swap with
//swap them
//reverse the array from 1st swap index plus +1 poition till end of the array

//Key condition:
//i>=0 and while
//i>=0 --important
//tricky case can be trivial by using the actual ascending...for that u only use reverse...
//T:0(n)
// S:0(1)
