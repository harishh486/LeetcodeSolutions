import java.util.*; 
class HelloWorld{ 
  
// Function to count the number 
// of ways to divide the number N 
// in groups such that each group 
// has K number of elements 
static int calculate(int pos, int prev,  
                     int left, int k) 
{ 
      
    // Base Case 
    if (pos == k) 
    { 
        if (left == 0) 
            return 1; 
        else
            return 0; 
    } 
  
    // If N is divides completely 
    // into less than k groups 
    if (left == 0) 
        return 0; 
  
    int answer = 0; 
      
    // Put all possible values  
    // greater equal to prev 
    for(int i = prev; i <= left; i++)  
    { 
       answer += calculate(pos + 1, i,  
                           left - i, k); 
    } 
    return answer; 
} 
  
// Function to count the number of  
// ways to divide the number N 
static int countWaystoDivide(int n, int k) 
{ 
    return calculate(0, 1, n, k); 
} 
  
// Driver Code 
public static void main(String[] args) 
{ 
    int N = 8; 
    int K = 4; 
  
    System.out.print(countWaystoDivide(N, K)); 
} 
} 