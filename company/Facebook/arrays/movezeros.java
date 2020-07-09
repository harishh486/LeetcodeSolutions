class Solution {
    public void moveZeroes(int[] nums) {
        int index =0;
        for(int i=0;i <nums.length;i++){
            if(nums[i]!=0){
                nums[index++] = nums[i];
            }
            
        }
        for(int i = index;i< nums.length;i++){
            nums[i] =0;
        }
        
    }
}


// maintain index
// if not 0 then at indexth place th evalue
//then at the index start from index at give zeros all the time till end
// t:  0(n)
//s : 0(!)
//inplace --no adiitional mem

