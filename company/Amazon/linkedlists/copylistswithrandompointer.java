/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // check the null comditions
        
        if(head == null)
            return null;
        
        //Now traverse the original list and add new nodes to the the Linked list 
        //to form a weavy linked list which contains both old and new nodes
        //random pts are left like that... we will handle that later
        
        //Create a pt to iterate
        Node ptr = head;
        
        while(ptr!= null){
            Node newnode = new Node(ptr.val);
            newnode.next = ptr.next;
            ptr.next= newnode;
            ptr = newnode.next;
        }
        
        //now A-A'-B-B' as a weavy list with original random ptrs to original nodes still in place
        //but random ptrs fro new weavy nodes are still unknown -- we need to figure it out
        
        ptr = head; // get back the ptr again
        
        // here we ll point the random pointers for new nodes will introduced
        
        while(ptr !=null){
           // A' random ;;;Since Ptr is at A
            ptr.next.random = ptr.random != null ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        
        //now we got A-A'-B-B' withrandom ptrs also assigned in both new and old nodes
        
        
        
       // Now we need to split
        Node oldptr = head;// points to A-B-C
        Node newptr = head.next; //points to A'-B'-C'
        Node resultptr = head.next; //which we need to return //since above one we use for traversing
        
        while(oldptr != null){
            oldptr.next = oldptr.next.next;
            newptr.next = newptr.next != null ? newptr.next.next : null ;
            //increment both since it is already old.ptr.next is pointing to original next ::update to
            oldptr = oldptr.next;
            newptr = newptr.next;
            
        }
        
        //now we split two different lists having own things
        //now return the result
        return resultptr;
        
    }
}


// T: O(N) -- since we visit the lists atleast one and we dont 
// S: 0(1) -- no hashtable 




// Check: the leetcode answer - well written


/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
public class Solution {
    public Node copyRandomList(Node head) {
  
      if (head == null) {
        return null;
      }
  
      // Creating a new weaved list of original and copied nodes.
      Node ptr = head;
      while (ptr != null) {
  
        // Cloned node
        Node newNode = new Node(ptr.val);
  
        // Inserting the cloned node just next to the original node.
        // If A->B->C is the original linked list,
        // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
        newNode.next = ptr.next;
        ptr.next = newNode;
        ptr = newNode.next;
      }
  
      ptr = head;
  
      // Now link the random pointers of the new nodes created.
      // Iterate the newly created list and use the original nodes' random pointers,
      // to assign references to random pointers for cloned nodes.
      while (ptr != null) {
        ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
        ptr = ptr.next.next;
      }
  
      // Unweave the linked list to get back the original linked list and the cloned list.
      // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
      Node ptr_old_list = head; // A->B->C
      Node ptr_new_list = head.next; // A'->B'->C'
      Node head_old = head.next;
      while (ptr_old_list != null) {
        ptr_old_list.next = ptr_old_list.next.next;
        ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
        ptr_old_list = ptr_old_list.next;
        ptr_new_list = ptr_new_list.next;
      }
      return head_old;
    }
  }
