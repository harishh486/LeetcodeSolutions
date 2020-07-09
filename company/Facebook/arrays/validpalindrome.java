class Solution {
    public boolean isPalindrome(String s) {
        
        if(s == null)
            return false;
        if(s.length() == 0 || s.isEmpty())
            return true;
        
        int i=0;
        int j=s.length()-1;
        while(i<j){
            
            while(i< j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while(i< j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            
            if(i<j && Character.toLowerCase(s.charAt(i++) )!= Character.toLowerCase(s.charAt(j--)))
                return false;
        }
        return true;
            
        
        
        
    }
}

// two pointers increment one and decrement one and compare

//if matches return true else false;

//use left and right ptr

//Character.isLetterOrDigit --remenber this firts letter then digit

//s.toLowerCase();

public boolean isPalindrome(String s) {
    if(s == null || s.length() == 0) return true;
    s = s.toLowerCase();
    for(int i = 0, j = s.length()-1;i<j;i++,j--){
        while(i<j && !Character.isLetterOrDigit(s.charAt(i)))
            i++;
        while(i<j && !Character.isLetterOrDigit(s.charAt(j)))
            j--;
        if(s.charAt(i) != s.charAt(j)) return false;
    }
    return true;
}