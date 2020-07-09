class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int count = m+n-1;
        
        --m; // index start from 0
        --n;
        
        while(m>=0 && n>=0){
            
            if(nums1[m] > nums2[n]){
                nums1[count--] = nums1[m--]; //post decrement
            }
            else{
                nums1[count--] = nums2[n--];
            }
        }
        
        while(n>=0){
            nums1[count--] = nums2[n--];
        }
        
    }
}


// T:0(n)
// S:0(n)
// n- length of nums1
// compare m and n and whatever big place at count and decrement count, m , n accordingly
//also while condition shud be &&
