/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head  = new ListNode(0);
        ListNode l3 = head;
        int carry = 0;
        //while loop to iterate or 
        while (l1 !=null || l2 != null ){
            
            
            //check the values if the lengths re not equal so that u can have zeros
            
            int l1_val = (l1 !=null) ? l1.val : 0;
            int l2_val = (l2 !=null) ? l2.val : 0;
            
            int val = l1_val+l2_val+carry;
            carry = val/10;
            int last_digit = val%10;
            ListNode newNode = new ListNode(last_digit);
            l3.next = newNode;
            
            //forward the 3 ptrs
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            l3 = l3.next;
           
        }
        // if we have carry like 9+9=18 in the last digits
        if(carry >0){
            ListNode carrynode = new ListNode(1);
            l3.next = carrynode;
            l3 = l3.next; // increment the l3 *****imp
        }
        
        
        return head.next;//return the head (not l3 )next becos the first one is dummy zero
        
    }
}




Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.


