public boolean validPalindrome(String s) {
        
    int i=0;
    int j = s.length()-1;
    
    while(i<j){
        if(s.charAt(i) != s.charAt(j)){
            return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
        }
        i++;
        j--;
        
    }
    return true;
    
}

private boolean isPalindrome(String s, int i, int j){
    while(i<j){
        if(s.charAt(i++) != s.charAt(j--)){
            return false;
        }
    }
    return true;
}

// T: 0(n)
// S:0(1)
// if(s.charAt(i++) != s.charAt(j--))  //++ -- becareful
// first and last ptr concept check 1st and last and if same ,inc and decrement
// else skip one element from i || skip one lement from j => (i+1,j)    (i,j-1) and if same then true else false
// dont forget to ++/--