class MedianFinder {
    
  PriorityQueue<Integer> max = new PriorityQueue(Comparator.reverseOrder());// max heap
  PriorityQueue<Integer> min = new PriorityQueue();

  public MedianFinder() {
      
  }
  
  public void addNum(int num) {
      // add to min
      // add to max by removing min
      // if min < max then remove from max and add to min
     min.offer(num);
     max.offer(min.poll());
     if(min.size() < max.size()){
       min.offer(max.poll());
     }
  }
  
  public double findMedian() {
      
      // if both size equal get peeks and /2
      //else min peek
     if(min.size() == max.size()){
       return (min.peek() + max.peek()) / 2.0;
     } else {
       return min.peek();
     } 
  }
}


T: o(logn) --add/delete fromheap and 0(1) for access median so logn
S:0(n)--we store in heap total n numbers

/**
* Your MedianFinder object will be instantiated and called as such:
* MedianFinder obj = new MedianFinder();
* obj.addNum(num);
* double param_2 = obj.findMedian();
*/

// Heaps are a natural ingredient for this dish! 
//Adding elements to them take logarithmic order of time. They also give direct access to the maximal/minimal elements in a group.
  
// If we could maintain two heaps in the following way:

// A max-heap to store the smaller half of the input numbers
// A min-heap to store the larger half of the input numbers
  
// The max-heap contains all the smaller numbers while the min-heap contains all the larger numbers


// All the numbers in the max-heap are smaller or equal to the top element of the max-heap (let's call it xx)
// All the numbers in the min-heap are larger or equal to the top element of the min-heap (let's call it yy)
// Then xx and/or yy are smaller than (or equal to) almost half of the elements and larger than (or equal to) the other half. That is the definition of median elements.
