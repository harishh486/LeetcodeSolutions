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
            //we ll add all
            maxHeap.offer(arr);
            // but we gonna keep only k elements so that at the end we ll have  k nearest points in the  heap
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


Algo:
// we ll constructr a max heap
// then we ll insert all the elements 
//  provided we only keep only k elements , so we pop all elements  from max heap , now we have only k elements and which are nearest to origin
//   now we iterate
//(O(n) + (n-K)log(K)) 

// //Time Complexity: O(n) + (n-K)log(K)
        //O(n) for builing the heap
        //and for every (n-K) element we go heapification which takes log(K) time