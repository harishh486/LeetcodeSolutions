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
    public ListNode reverseList(ListNode head) {

        
        
        // define 3 pts prev, curr and next
        // prev - null
        // curr - current head
        // just initialize next so that we can use later
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        
        while(curr != null){
            // keep track of next element of the current node 
            // then reverse the curr-next to prev //u turn 
            next = curr.next;
            curr.next= prev;
            //move prev to curr and
            // move curr to next
            prev = curr;
            curr = next;
        }
        return prev; // since curr reaches to null, prev will be at the last node pointing and acts as a head
        
    
        
    }
}


// T: 0(n)  // length of list
// S: o(1)


// Recursive

// 1) Divide the list in two parts - first node and 
// rest of the linked list.
// 2) Call reverse for the rest of the linked list.
// 3) Link rest to first.
// 4) Fix head pointer


if(head == null || head.next== null)
return head;

//reverse
ListNode rest = reverseList(head.next);
head.next.next= head;
head.next= null;

return rest;