class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // three sum closest 
        //2 ptrd so sort
        //fix one and move remaining i+1 and last one
        //result initialization later nums[0]+nums[j]+nums[nums.length-1]
        //iterate over loop and find results
        
        int result = nums[0]+ nums[1]+ nums[nums.length-1]; //initialize random
        Arrays.sort(nums);
        //compare only upto len-2 since we need 3 numbers
        for(int i=0; i< nums.length-2;i++){
            int a_ptr = i+1;
            int b_ptr = nums.length-1;
            while(a_ptr < b_ptr){
                int curr_sum = nums[i]+ nums[a_ptr]+nums[b_ptr];
                if(curr_sum > target){
                    b_ptr -=1;
                } else{
                    a_ptr +=1;
                }
                // check dist btwerrn current sum and target vs alreadycalculatedsum- target which ever is least assiugn to result
                // we will check if the abs value of currentsum-target is smmaler than fistance btw //result-target::::meaning which hops are small, then if its hops are small then its closest
                if(Math.abs(curr_sum - target) < Math.abs(result-target))
                    result = curr_sum;
            }
        }
        return result;
        
    }
}


//t: O(n*n) 2 loops iterate  + sort (nlogn) ==> o(n*n) + nlogn
//S: o(n)-o(logn) // depends on implementation of sorting algorithm
//depends on the sorting algorithm
//but here 0(!) * sort algo one :::As no extra space is required

//Can we achieve space 0(1) ?
// you can achieve O(1) memory complexity, you can use the selection sort instead of a built-in sort in the Two Pointers approach. 
//It will make it a bit slower, though the overall time complexity will be still 0(n^2)
