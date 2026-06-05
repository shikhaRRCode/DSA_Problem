class LRUCache {
    class Node{
        int key,value;
        Node next,prev;
        Node(int key , int value){
            this.key = key;
            this.value = value;
        }
    }
    public void remove(Node root){
        root.prev.next = root.next;
        root.next.prev = root.prev;
    }
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
        remove(curr);
        add(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            curr.value = value;

            remove(curr);
            add(curr);
            return;
        }

        if(map.size() == capacity){
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }
        Node newNode = new Node(key , value);
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