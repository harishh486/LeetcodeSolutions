
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        
        if(intervals.length ==0){
            return 0;
            
        }
        
        // sort like merge intervals
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        // [[0, 30],[5, 10],[15, 20]]
        // use minheap to store end times
        
        // 30 
        PriorityQueue<Integer> minHeap = new PriorityQueue();

        for(int[] arr : intervals ){
            
            // check min heap emptyness else null ptr exception
            // if the next meeting does not coincides then there is no need of extra room
            // u can use same room
            if(!minHeap.isEmpty() && minHeap.peek() <=arr[0])
                minHeap.poll();
            
            // we ll just add the arr lemnts which are coinciding
            minHeap.offer(arr[1]);
            
            
            
        }
        
        return minHeap.size();
        
    }
}


// Instead of manually iterating on every room that's been allocated and checking if the room is available or not, 
//we can keep all the rooms in a min heap where the key for the min heap would be the ending time of meeting.

// So, every time we want to check if any room is free or not, simply check the topmost element of the min heap as that 
//would be the room that would get free the earliest out of all the other rooms currently occupied


T: nlogn
S: o(n)--minheap space
