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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        

        // standard Head node declaration
        
         ListNode head = new ListNode(0);
         ListNode l3 = head;
        int carry=0;
        
        
        while(l1 != null || l2 != null){
            
            int l1_val = l1 != null ? l1.val :0 ;
            int l2_val = l2 != null ? l2.val :0 ;
            int current_Sum = l1_val+l2_val + carry;
            
            carry =  current_Sum/10;
            int lastdigit = current_Sum%10;
            
            l3.next = new ListNode(lastdigit);
            
            // increment all 3 pts but check the value of l1 and l2 before increment
            if(l1!= null)
                l1 = l1.next;
            if(l2!= null)
                l2 = l2.next;
            
            l3 = l3.next;
            
            
          
        }
        
        // u may get a carry later on 
        
        if( carry>0){
            l3.next = new ListNode(carry);
            
            l3 = l3.next;
        }
        
        
        return head.next; // return the initial.next
        
        //main logic here is u generally calculate the values but it is represented in reverse order in LL
        
    }
}


// T:0(Max(m,n))
// S: : O(max(m,n)). The length of the new list is at most max(m,n) + max(m,n)+1.