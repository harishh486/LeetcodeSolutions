class Solution {
    public List<String> generateParenthesis(int n) {
        
        // standard template for recursion
        
        List< String> result = new ArrayList();
        
        if(n==0)
            return result;
        helperRecursive(result, n, "", 0,0);
        return result;
    }
    private void helperRecursive( List< String> result, int max, String combination,  int open , int close){
        
        // base case:: current string shud be of full length then stop becos we need full length things
        if(combination.length() == max*2){
            result.add(combination);
            return;
        }
        
        // recursive call and operations if any
        // we ll try to increase "(" whenever possible like  no of open ( is still less than max n=3, we ll recurse
        if(open < max)
            helperRecursive(result, max, combination+ "(", open+1,close);
        if(close< open)
            helperRecursive(result, max, combination+ ")", open,close+1);
        
    }
}


// Back trac king:: Recursive


T: 0(2^n)
every index there can be two options ‘(‘ or ‘)’.
it can be said that the upperbound of time complexity is O(2^n) 
or it has exponential time complexity.

S: o(n)
since we store max*2 length


//Backtrack --dfs 