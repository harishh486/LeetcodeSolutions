class Solution {
    public int search(int[] nums, int target) {
        
        
        // Since it is sorted and we need to search--BInary search--o(logn)
        // we can tweak the search
        //    [4,5,6,7,0,1,2]
        int left =0;
        int right = nums.length-1;
        
        //regular binary search loop
        while(left <= right){
            int mid = left + (right-left)/2;
            
            if(nums[mid] == target)
                return mid;
            // if thhis loop is sorted or othher loop needs to sort somehow
        
            else if (nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid])
                    right = mid-1;
                else
                    left = mid+1; 
            }
            else{
                if(target >= nums[mid] && target <=nums[right])
                    left = mid+1;
                else
                    right = mid-1;
                
            }
        }
        
        return -1;
        
    }
}


//       // [4,5,6,7,0,1,2]
//             //  0 1 2 3 4 5 6

//             // tweal 
// S:0(1)

// T: o(logn)

// We need to tweak little bit to check additional conditions

// Just draw th diagrams and u ll get the Solution
// and every comparison is <= or >=

