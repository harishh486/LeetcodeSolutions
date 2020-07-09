class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums == null || nums.length ==0)
            return 0;
        
        int i=0;
        for (int j=0;j<nums.length;j++){
            
            if( nums[i] != nums[j] ){
                i++;
                nums[i] = nums[j];
                
            }
        }
        
        return i+1;
        

    }
}


//Accepted:
// slow and fast pointer concept
// if both matches do nothing just j++
// if does not match
//a) increment i++; b) replace current ith value in array with current jth value 
//traverse this until j reaches end of the array
//return length which is slow pointer +1;
//return i+1; (*******)
//0(n)--time
//0(1)==space--inplace
