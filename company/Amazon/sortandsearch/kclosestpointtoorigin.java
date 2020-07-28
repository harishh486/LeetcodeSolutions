class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
          PriorityQueue<int[]> maxHeap=new PriorityQueue<>(new Comparator<int []>(){
           public int compare(int a[],int b[]){
               return  ((b[0]*b[0])+(b[1]*b[1])) - ((a[0]*a[0])+(a[1]*a[1]));
           }
            
        });
        
        //max heap shud be based on distance square root from origin ,
        //klogk
        for(int[] arr : points ){
            maxHeap.offer(arr);
            if(maxHeap.size() > K)
            maxHeap.poll();
        }
        
        int[][] result = new int[K][2];
        while(K-- > 0){
            result[K] = maxHeap.poll();
        }
        
        return result;
        
        
    }
}


//(O(n) + (n-K)log(K)) 

// //Time Complexity: O(n) + (n-K)log(K)
        //O(n) for builing the heap
        //and for every (n-K) element we go heapification which takes log(K) time