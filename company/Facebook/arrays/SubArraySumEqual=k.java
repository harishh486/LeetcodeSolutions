class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0;
        int result=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0; i< nums.length;i++){
            sum+=nums[i];
            
            if(map.containsKey(sum-k)){
                result+= map.get(sum-k);
            }
            
            map.put(sum, map.getOrDefault(sum,0)+1);
            
        }
        
        return result;
    }
}



// T:0(n) --runs full array and traverse atleast once
// S:0(n) --since hashmap has n no of unique entries

// This problem is  like
// Initialise map(0,1) => means it occurs sum 0 for 1 time. // base case
// Map(sum till now, and count that sum occurs how many times till now)

// [1 1 1]
// Map:
// (0,1) -> 
// (0+1,1) - > 
// (1+1,1) -> 
// (2+1,1)

// Result :
// -2
// -1
// 0  -this is already in hashmap , increment result onnce
// 3-2=1 => also in map ==> increment result one more time

// 1 1 1
// k=2
// 1 2 3 

// 2 pts concept is also same here 
// i, j starts at same time and j ++ till the sum is <given K, if its greater than i ++;
// important techjnique