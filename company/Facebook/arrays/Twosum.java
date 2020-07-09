import java.util.HashMap;
import java.util.Map;

// use hashmap--save the num[i] with its iindex in hashmap
// for evry loop check if compliment is present , if it present return the current number index and the get the compliment s value from hashmap
// k,v ==> num[i], index
// Time 0(n)
//Worst case fo reach element we store, we get the compliment 0(1) n times
// for hashing its only 0(1)

class Twosum {
    public static int[] twoSum(int[] nums, int target) {
        
        Map< Integer, Integer> hashmap = new HashMap<>();
        for (int i=0; i< nums.length; i++){
            int compliment = target-nums[i];
            
            if(hashmap.containsKey(compliment)){
                return new int[] {hashmap.get(compliment),  i};
            }
            
            hashmap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Such solution is present");
        
    }
        
    public static void main(String[] args) {
        
       int num [] = {2, 7, 8, 6};
    
  
        System.out.println(twoSum(num, 9));
     }
}


