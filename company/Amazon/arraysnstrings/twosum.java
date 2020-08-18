class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap <Integer,Integer> hmap= new HashMap();
        
        for (int i=0 ; i< nums.length; i++){
            
          if(hmap.containsKey(target-nums[i])){
              return new int[]{ hmap.get(target-nums[i]), i};  
          }
            
          hmap.put(nums[i],i);   
        }
        
        throw new IllegalArgumentException("No two sum solution");
        
    }
}


// Given nums = [2, 7, 11, 15], target = 9,
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].


// T: 0(n) -- traverse list atleast once, and search time in hash would be 0(1) ==> 0(n)
//  S: 0(n)--atmost n elements we store
// brute force: search for all pairs and make them equal tp target
// keep one constant and other one moving wher target-y = x which is constant
// Hashmap
// a +b = c => a= b-c

//store a in hashmap with index i.
// check  hashmap with containsKey(compliment)==> iif present then get those  index and current index



//tricky:

// forgot the return like 

//throw new IllegalArgumentException("no such");

//also get and check both complinents in hashmap


/