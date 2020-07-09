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
        if(head == null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        Node curr = head;

        while(curr !=null){
            if(map.get(curr) == null){
                map.put(curr, new Noe(curr.val, null, null));
    
            }
            curr= curr.next;
        }
        curr = head;
        while(curr != null){
            map.get(curr).next = map.get(curr.next); //once u get then u ll retuyrn values
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
        
    }
}

//Did not executed please execute in leetcoee

// Have a map <node, node>

// copy the list in the firts iteration
// same like

// 1-2-3

// Key: O: 1, next, ori-2,next, ori-3,next,orig
// Value: N: 1, null, null-2,null,null-3,null,null

// Second iteration 

// we ll get the curr-next node from map then assign to curr- next 

// T: O(n) and hashmap is 0(1) so it has o(n)