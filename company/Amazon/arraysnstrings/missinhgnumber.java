class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        for (int i=0;i< nums.length;i++)
            sum += nums[i];
        int n = nums.length +1; //.  one number might miss right so incement the n values 
        System.out.println(n);
        return ((n*(n-1)/2) - sum);
    }
}

// 1,2,3...n == n(n+1/2)
// 0 1 2 3.. n-1 = n(n-1/2  hwee n =n-1)
// n(n-1)/2

// T:  o(ne
// S: 0(1)

class Solution {
    public int missingNumber(int[] nums) {
   
        HashSet<Integer> hs  = new HashSet();

        for (int i=0;i< nums.length;i++){
            hs.add(nums[i]);

        }
        //upto n and including n so <=
        for (int i=0;i<= nums.length;i++){
            if(!hs.contains(i)){
                return i;
            }
            
        }
        return -1;

        

    }
}

