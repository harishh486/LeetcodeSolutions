
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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        
        while(pointer != null){
            
            ListNode node = pointer;
            // clarify we have atleast k nodes
            
            for(int i=0; i<k && node!= null;i++){
                node= node.next;
            }
            // if there are no enough nodes break
            if(node == null)
                break;
            // now we have enough nodes if we get here
            
            // do logic reverse
            
            ListNode prev = null;
            ListNode curr = pointer.next;
            
            
            // instead of while use for loop and upto 3 nodes onl
            for(int i=0; i<k ; i++){
                ListNode next= curr.next;
                curr.next= prev;
                prev= curr;
                curr= next;  
            }
            
            // look at the diagram
            // now tail needs  to process 
            ListNode tail =  pointer.next;
            //becos now is the in the next group , prev is the last element which acts a s head after reversing
            
            tail.next = curr;
            
            // now pointer shpuld become initial one, so next of pointer shouuld point to prev .. since prev is the starting node
            
            pointer.next = prev;
            // now like wise pointer shoul move to tail since it is the strting before node
            // now curr is the starting node of the next group//
            // but pointer should be the tail node for the next group
            pointer = tail;
            
            
            
        
        }
        
        // at the end dummy is still the 0th node 
        //and everything is aligned 
        return dummy.next;
        
        
    }
}




T:0(n)
S:0(!)



This problem can be split into several steps:

Since we need to reverse the linked-list every k nodes, we need to check whether the number of list nodes are enough to reverse. Otherwise, there is no need to reverse.

If we need to reverse the k nodes, how to do that? Following is my idea:

If the structure of the linkedlist is like this:

 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
Then there will always be a pointer, which points to the node AHEAD of the first node to reverse. The pointer will help to link the linkedlist after.

At first, we will add a dummy node in front of the linked list to act as the first pointer. After we add the pointer, the linked list will look like this:

    0 (pointer) -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
Suppose that there are enough nodes to be reversed, we just use the "reverse linked list" trick to reverse the k nodes. Please refer to "https://leetcode.com/problems/reverse-linked-list/" if you don't know how to reverse a linked list.

if k = 3, we can reverse 1 to 3 first using the following code:

  ListNode prev = null, curr = pointer.next, next = null;
  for (int i = 0; i < k; i++) {
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
  }
This is the illustartion of the first 3 steps:

    step1: 0 (pointer) -> 1      2 -> 3 -> 4 -> 5 -> 6 -> 7
	step2: 0 (pointer) -> 1 <- 2      3 -> 4 -> 5 -> 6 -> 7
	step3: 0 (pointer) -> 1 <- 2 <- 3      4 -> 5 -> 6 -> 7
This is an easy and general algorithm to reverse a linked list. However, if you are careful enough, you will find that after the for-loop, the link from 3 to 4 will be cut (as shown in step3).

Now we need to reconstruct the linked list and fix the issue. You will figure out that at step3, the 3 is the prev node, 4 is the curr node.

	step3: 0 (pointer) -> 1 <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
We can fix the sequence based on the following codes. The basic idea is to link the pointer to 3 and link 1 to 4:

	ListNode tail = pointer.next;
	tail.next = curr; 
	pointer.next = prev;
	pointer = tail;
Then the result is:

	after first line:   0 (pointer) -> 1 (tail) <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
	after second line:  0 (pointer) -> 1 (tail) <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
								       |____________________________↑
	after third line:   
								|-----------------------↓
						0 (pointer)    1 (tail) <- 2 <- 3 (prev)    4 (curr) -> 5 -> 6 -> 7
									   |____________________________↑
									   
	after forth line:	0 -> 3 -> 2 -> 1 (pointer) -> 4 -> 5 -> 6 -> 7
