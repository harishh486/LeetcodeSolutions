class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
         // maintain a map for frequency
        //[1,1,1,2,2,3],
        // 1-3
        // 2-2
        // 3-1
        
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap();
        //iterate and put 
        
        // 1. build hash map : character and how often it appears
        // O(N) time
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)  + 1);
        }
        
        //maxHeap should be ordered in such a way that based on the frequency count it shud be there, so that top 3 will be top k elements
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
        // now go thru the key elements of the map and push to the queue then we ll get the top k elements by polling upto K

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for(int x : map.keySet()){
            // now push all k, and it will be inserted based on the count frequency of the elements
            maxHeap.offer(x);

            
        }
          // 3. build an output array
        // O(k log k) time -- for every elment which is k-- we do polling which takes logk time
        // once filled with max heap all key elements
        for(int j=0 ; j<k;j++){
            result[j] = maxHeap.poll(); 
        }
        return result;
        
    }
}

// Constarint: shud be less than nlogn which is nlogk here
// Time:
// Build map -o(n)
// Time complexity :O(Nlogk) if k < N and O(N) in the particular case of N = k. 
// That ensures time complexity to be better than ~O(NlogN).

// Space complexity : 0(N+k) to store the hash map with not more NN elements and a heap with kk elements.

.