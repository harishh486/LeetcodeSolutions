// we can use linked list

// 1-2-3-4

// get(3)  in o(1)  ?? how?
// find a way to not to iterate ?
// // capture direct reference, keep MAp
// key is number and value is node reference
// so i need something to have prev and next reference

// dd .put(5,v)-- double linked list
// constant time to insert/remove
// Since 0(1)  --> u can have hashmap
// limited memory

// Rules:

// 1. Most recently used need to keep in cache, if u touch the element, then its means it is accessed recently
// like get() or insert() etc
// 2. Decide DS first
// 3. Hashmaps --constant lookups, put and get operation --UN Ordered  0(!)
// 4. Deleting the recently least used::: and inserting the most recently used
// 5. when accessed it needs to put at front
// 5. ll--constant time in inserts 
// Double linked list--we have reference to head and tail , prev and next


// {
//     1:1
//     2:2
//     3:3
// }


class LRUCache {
    final Node head = new Node();
    final Node tail = new Node();
    
    // need map
    HashMap<Integer, Node> node_map;
    int capacity;

    public LRUCache(int capacity) {
        // init
        // init the map with capacity so taht we only store those much
        
        node_map = new HashMap(capacity);
        this.capacity = capacity;
        //head--tail
        head.next = tail;
        tail.prev = head;
        
        
        
    }
    
    
    // add to add nodes in front of list
    // add nodes to cache
    
    public void add(Node node){
       // 1-2-3-4  add 5// add a node at front of the linkedlist
        
        //head-1-2-3-tail. now add 5
        // head-5-1-2-3-tail
        // So get hold of head of nextc node so that u need later
        
        Node head_next = head.next;
        //first use right connections and left later
        node.next = head_next;
        head_next.prev = node;
        
        head.next = node;
        node.prev = head;
        
        
    }
    
     // remove to remove nodes in end of list
    public void remove(Node node){
        
        //1-2-3 passed 2
        
        // simple easy if u draw a diagram
        
        Node next_node = node.next;
        Node prev_node = node.prev;
        prev_node.next = next_node;
        next_node.prev = prev_node;
        
        
    }
    
    // get 
    public int get(int key) {
        
        int result = -1;
        // we return -1 if not present;
        Node node = node_map.get(key);
        if(node  != null){
            result = node.val;
            remove(node);
            add(node);
            //remove and node means --move to front since we used
            
        }
        return result;
        
    }
    
    public void put(int key, int value) {
        // key is dat and value is the index where it is stored 
        // adds or overwrites it
        //1. overwrites it, which means it already has it and u. dont have to check the capacity since the ndoe is already inplace
        Node node = node_map.get(key);
        if(node != null){
            remove(node);
            //updte the value
            node.val = value;
            add(node);
        }else{
            //we need to add
            // we need to check capacity
            if(node_map.size() == capacity){
                //remove from tail
                //remove from hashmap and linked list as well;
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }
            // now add node
            Node new_node = new Node();
            new_node.key = key;
            new_node.val = value;
            
            // then u put in map
            node_map.put(key, new_node);
            //add to list
            add(new_node);
            
        }
        
        
        
    }
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


//  Summary:
//  - craete a DLL node which has key and value
// - eviction policy --LRU
// - Access from front or add to front  :::: remove from back end
// DS:
// - req:
// get()
// put()
// Time o(!)
//  get and put item in constant time

//  fast lookups --  Hashmaps (hashtable) but cannot 
//  fast remove/puts -- if we have access to current node , i can remove the node in constant timme
//  since single LL takes o(n) to search for previou node so use DLL for fast removal
//  array is not good --since we need shiftig 

//  So dll backed by hashmap

//  so hash table put and get

//  add - add  the nodes in dll at front
//     Node head_next = head.next;
//     //first use right connections and left later
//     node.next = head_next;
//     head_next.prev = node;

//     head.next = node;
//     node.prev = head;

//  remove --removes the node in dll at the end

//     //1-2-3 passed 2
//     // simple easy if u draw a diagram
//         Node next_node = node.next;
//         Node prev_node = node.prev;
//         prev_node.next = next_node;
//         next_node.prev = prev_node;

// - 

// get - get the value node HashMap<Integer, Node> node_map;
//      -- get the node first then pick  the value from this node and return
//      -- since we accessed , remove from current position and add to front
//      Node node = node_map.get(key);
//      if(node  != null){
//          result = node.val;
//          remove(node);
//          add(node);
//          //remove and node means --move to front since we used
         
//      }
//      return result;

// put -- put the key and node and value to hashmap

// 1. if present then overwrites
//      // get the node and update the value and do shuffle positions remove and add
//        Node node = node_map.get(key);
//        if(node != null){
//            remove(node);
//            //updte the value
//            node.val = value;
//            add(node);
//        }
// 2. if not present, then check capacity , 
//       if capacity is full evict/remove from  hashmap and dll 
//             if(node_map.size() == capacity){
//               //remove from tail
//               //remove from hashmap and linked list as well;
//               node_map.remove(tail.prev.key);
//               remove(tail.prev)
//     else if we have capacity then add to hashmap and dll
//         Node new_node = new Node();
//         new_node.key = key;
//         new_node.val = value;
        
//         // then u put in map
//         node_map.put(key, new_node);
//         //add to list
//         add(new_node);
        
      