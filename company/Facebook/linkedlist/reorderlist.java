/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {



        /// here we  deduce logic has 
// first we ll have two pointers slo and fast once fast reaches end we get in to mid point 

// so at the end og this will have two pointer  list  l1 and l2 so keep track of head  with l1 and since mid point prev.next point to null as the end to first  list.


// once u get the second list , reverse it and 

//once  u have original half  list and reversed list

//merge it using merge logic.
        
// check the head conditons to be OR instead of AND

        if  (head == null || head.next ==  null)
            return;
        
        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            // check all these. condition for acurate info
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            
        }
        prev.next = null; // crucial step


        ListNode l2 = reverse(slow);
        merge(l1,l2);
          
        
    }
    
 //  simple merge logic is we have two lists 

 // create two temp lists for next of p1 and p2 so that u have track of this.

 // p1.next goes to p2 and p2.nextgoes to temp1 which is p1's next 

 // and adbvance two pointers

 public  void merge(ListNode p1, ListNode p2) {
        
    //merge two lists
    
    while( p1  != null){
        //. take two.temp pointers
        ListNode temp1 = p1.next;
        ListNode temp2 = p2.next;
        p1.next =  p2;
        
        
        if(temp1 == null)
            break;
        
        p2.next = temp1;
        
        p1 =  temp1;
        p2 =  temp2;
        
        
    }
}
    
    // reverse logic is simple
    // mainly 1. prev, 2. curr, t3. emp

    //1. initial prev -> null

    //2.   curr goes to head

    //while looping  on curr and have a 
    // 3.  temp ptr point to curr.next;

    // logic steps

    // curr.next = prev
    // prev goes to curr and

    // curr goes to temp

    // so 2-> 1> 3 and return 1;
    
    public static ListNode reverse(ListNode head) {
        
        
        ListNode pre = null;
        ListNode curr = head;
        
        while(  curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        
       
        return pre; // important step
        
    }
    
}



        /// here we  deduce logic has 
// first we ll have two pointers slo and fast once fast reaches end we get in to mid point 

// so at the end og this will have two pointer  list  l1 and l2 so keep track of head  with l1 and since mid point prev.next point to null as the end to first  list.


// once u get the second list , reverse it and 

//once  u have original half  list and reversed list

//merge it using merge logic.