/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head  = new ListNode(0);
        ListNode l3 = head;
        
        
        //loop the two lists &&
        while(l1 != null &&  l2 != null){
            // if l1 < l2 then add that node to the final node l3
            if(l1.val < l2.val){
                l3.next = l1;
                l1 = l1.next;
            }else{
               l3.next = l2; 
                l2 = l2.next;
            }
            
            // u need to increment the l3
            l3 = l3.next;
        }
        
        //if anyone of the l1 or l2 is not having same length
        if(l1 != null){
            l3.next = l1;
            l1 = l1.next;
        }
        if(l2 != null){
            l3.next = l2;
            l2 = l2.next;
        }
        
        //return lways head .next becos head is dummy with 0
        return head.next;
        
    }
}



Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4