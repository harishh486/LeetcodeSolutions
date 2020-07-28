class Solution {
    public boolean isHappy(int n) {
        int slowptr = n;
        int fastptr = n;
        
        do {
            slowptr = findSquares(slowptr);
            fastptr = findSquares(findSquares(fastptr));
        } while(slowptr != fastptr);
        
        return slowptr == 1;
  
    }

    int findSquares(int num){
        int sum=0;
        int digit;
        
        while(num>0){
            digit = num%10;
            sum = sum + digit*digit;
            num = num/10;
        }
        
        return sum;
        
    }
    
}


// detect the loop problem two pointer
// or simple hash set problem

//T: 0(logn)    Digit d  and number n relation 
// d ~ logn
// ---check notes --pencil
//S: 0(1)



Recursive


class Solution {
    
    HashSet<Integer> set = new HashSet();
    public boolean isHappy(int n) {
        // recursive
        return isHappyRecursive(n);
  
    }
    
    private boolean isHappyRecursive(int num){
        if(num == 1)
            return true;
        
        int sum=0;
        int digit;
        
        while(num>0){
            digit = num%10;
            sum = sum + digit*digit;
            num = num/10;
        }
        if(set.contains(sum))
            return false;
        set.add(sum);
        return isHappyRecursive(sum);
        
    }

    
}