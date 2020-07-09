class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> results = new LinkedList();
        
        if (nums.length ==0 || nums.length <3)
            return results;
        
        Arrays.sort(nums);
        //sort the list so that it is good for comparison in case of duplicates
        
        for (int i=0; i< nums.length -2 ; i++){
            if(i ==0 || (i>0 && nums[i]!= nums[i-1])){
                int low = i+1;
                int high = nums.length-1;
                int target = 0-nums[i];
                //a+b =-c > a+b = 0-c
                while(low< high){
                    
                    if(nums[low]+ nums[high] == target){
                        results.add( Arrays.asList(nums[low], nums[high], nums[i]));
                          while(low < high && (nums[low] == nums[low+1])){
                           low++;
                            
                        }
                        while(low < high && nums[high] == nums[high-1]){
                            high--;
                            
                        }
                        low++;
                        high--;
                      
                        
                    }
                    else if(nums[low]+ nums[high] > target){
                        high--;
                        
                    }
                    else{
                        low++;
                        
                    }
                }
            }
        }
        return results;
    }
}

// sort the problem
  //a+b = -c;
  //check duplicates if processed previous one then skip next one 
  // for loop is upto nums.length-2  becos we need the two elements for 
  // 3 sum one being target and other two as two elements for 2 sum
  // and also we need no duplicates.


     