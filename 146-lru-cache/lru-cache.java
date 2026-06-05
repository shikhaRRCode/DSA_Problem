class LRUCache {
    // node of doubly linked list
    class Node{
        int key,value;
        Node next,prev;
        Node(int key , int value){
            this.key = key;
            this.value = value;
        }
    }
    // remove a node from linked list
    public void remove(Node root){
        root.prev.next = root.next;
        root.next.prev = root.prev;
    }

    // add node just after head
    // (mark as Most Recently Used)
    public void add(Node root){

        root.next = head.next;
        head.next.prev = root;

        root.prev = head;
        head.next = root;
    }
    Node head , tail;
    HashMap<Integer,Node> map;
    int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        map = new HashMap<>();

        // dummy head and tail nodes
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node curr = map.get(key);
        // move node to front (MRU)
        remove(curr);
        add(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        // key already exists
        if(map.containsKey(key)){
            Node curr = map.get(key);
            // update value
            curr.value = value;

            // move to front (MRU)
            remove(curr);
            add(curr);
            return;
        }
        // cache full
        if(map.size() == capacity){
            // remove Least Recently Used node
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }
        Node newNode = new Node(key , value);
        // add as Most Recently Used
        add(newNode);
        map.put(key , newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */