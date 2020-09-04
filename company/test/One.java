import java.util.*; 
class One{ 

public static void main(String[] args) 
{ 
    int N = 107; 
    int K = 37; 
    System.out.print(countOptions(N, K)); 

} 

public static long countOptions(int people, int groups){
    return helperCount(0,1,people, groups);
}


static int helperCount(int pos, int prev,  
                     int left, int groups) 
{ 
      
    // Base Case 
    if (pos == groups) 
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
       answer += helperCount(pos + 1, i,  
                           left - i, groups); 
    } 
    return answer; 
} 
} 