class Solution {
    public int maxArea(int[] height) {
        
        if (height.length == 0)
            return 0;
        
        
        int max =0;
        int left = 0; //first ptr
        int right = height.length -1;  //last ptr
        

           //logic 
        while(left < right){
            max = Math.max(max, (Math.min(height[left], height[right]) * (right-left)));
            if (height[left] < height[right])
                left ++;
            else 
                right--;
            
        }
        
    
        return max;
        
        
    }
}



T: 0(n)
s: 0(1)