class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        
        //push all into the min heap and remove until the last k elements 
        //then kth element will be the root , we can remove that
        
        for(int i: nums){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        
        //now whe have last K elements we can remove the root which is the smallest in the tree/heap
        
        return minHeap.remove();
        
    }
}

T: The time complexity of adding an element in a heap of size k is (logk), 
--N times that means O(Nlogk)

This algorithm improves time complexity, but one pays with O(k) space complexity.

// Arrays.sort(nums); --nlogn
// return nums[nums.length -k]


