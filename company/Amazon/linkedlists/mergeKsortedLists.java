
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        // we can use priority queue , default -which is minHeap implementation
        
         Comparator<Integer>intComparator = (s1, s2) -> {
             return s1-s2;
         }; // smallest value to largest value sort comparator
        
        PriorityQueue <Integer> pq = new PriorityQueue(intComparator );
        
        //insert all nodes in to this and pick one by one
        // pq.  add method  and pq.remove 
        for(ListNode head : lists){
            // use while instead of if::: since we need to iterate all over the list 
            while(head!= null){
                pq.add(head.val);
                head = head.next;
                
            }
        }
        // once we build a pq  now we ll have one dummy list and remove lements from minheap
        
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        
        //iterate over priorityQueue until is empty
        while(!pq.isEmpty()){
            result.next = new ListNode(pq.remove());
            result = result.next;
        }
        
        return dummy.next;
        
        
        
    }
 }
 
 // use minHeap Priority Queue
 
 // default implementation is min Heap
 // load all of them and try to remove one by  one

 // any operation for heap wiill be logk either insertion and deletion
//  so 2 logk times work

//  but it needs to do for n elemnets in all sorted k arrays so 
//  T: n logk
//  S: 0(N) -- for  storing all elements in heap


// Divide and conquer



// class Solution {
//     public ListNode mergeKLists(ListNode[] lists) {
        
//        // divide and conquer
        
        
//         // if(lists.length==0)
//         //      return NULL;
//         //  if(lists.length==1)
//         //      return lists[0];
 
//          return divideConquerLists(lists,0,2);
        
        
//     }
     
//      ListNode divideConquerLists(ListNode[] lists, int start, int end) {
//          if(start+1<end) {
//              int mid=(start+end)/2;
//              ListNode head1=divideConquerLists(lists,start,mid);
//              ListNode head2=divideConquerLists(lists,mid+1,end);
//              return mergeTwoLists(head1,head2);
//          } else if(start+1==end) {
//              return mergeTwoLists(lists[start],lists[end]);
//          } else {
//              return lists[start];
//          }
//      }
     
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         
         
//          ListNode head = new ListNode(0);
         
//          ListNode l3 = head;
         
         
//          while(l1!= null && l2!= null){
//              //if both are at same length the this loop will execute the case
             
//              if( l1.val< l2.val){
//                  l3.next = new ListNode(l1.val);
//                  // increment the l1
//                  l1 = l1.next;
                 
//              }
//              else{
//                  l3.next = new ListNode(l2.val);
//                  // increment the l2
//                  l2 = l2.next; 
//              }
//              // increment the l3
//              l3 = l3.next;
               
//          }
         
//          // now handle the short or long cases where one list is longer than othyer
         
//          if(l1 != null ){
//              l3.next = l1;
//              l3 = l3.next;
             
//          }
//          if(l2 != null ){
//              l3.next = l2;
//              l3 = l3.next;
             
//          }
         
         
//          return head.next;
         
         
         
//      }
//  }
 
 
//  S:0(1) just like merge lists
//same Time 