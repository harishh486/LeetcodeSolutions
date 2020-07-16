/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        
        ListNode head = new ListNode(0);
        
        ListNode l3 = head;
        
        
        while(l1!= null && l2!= null){
            //if both are at same length the this loop will execute the case
            
            if( l1.val< l2.val){
                l3.next = new ListNode(l1.val);
                // increment the l1
                l1 = l1.next;
                
            }
            else{
                l3.next = new ListNode(l2.val);
                // increment the l2
                l2 = l2.next; 
            }
            // increment the l3
            l3 = l3.next;
              
        }
        
        // now handle the short or long cases where one list is longer than othyer
        
        if(l1 != null ){
            l3.next = l1;
            l3 = l3.next;
            
        }
        if(l2 != null ){
            l3.next = l2;
            l3 = l3.next;
            
        }
        
        
        return head.next;
        
        
        
    }
}


Time complexity : O(n + m)O(n+m)
Because exactly one of l1 and l2 is incremented on each loop iteration,
 the while loop runs for a number of iterations equal to the sum of the lengths of the two lists. 
 
All other work is constant, so the overall complexity is linear.

Space complexity : O(1)

The iterative approach only allocates a few pointers, so it has a constant overall memory