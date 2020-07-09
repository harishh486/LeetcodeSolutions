class Solution {
    public boolean isValid(String s) {
        
        Stack <Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()){
            
            if(c =='(' || c=='{' || c == '['){
                stack.push(c);
            }
            else{
                if (stack.isEmpty())
                    return false; // meaning it does not has closing barcke
                if(c == ')' && stack.pop() != '(')
                    return false;
                if(c == ']' && stack.pop() != '[')
                    return false;
                if(c == '}' && stack.pop() != '{')
                    return false;
            }
        }
        return stack.isEmpty();
        
    }
}

// STack up every char if its opening brace
// when poping up it shud be the one which is opened
//at the end stack shud be empty meaning even and completed
//T: 0(n)
//S:0(n)