class LFUCache {
    class Node{
        int key, value , freq;
        Node next , prev;
        Node(int key , int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    class DLL{
        Node head , tail;
        int size;

        DLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        public void add(Node node){
            node.next = head.next;
            head.next.prev = node;

            node.prev = head;
            head.next = node;
            size++;
        }

        public Node removeLast(){
            if(size == 0){
                return null;
            }

            Node lru = tail.prev;
            remove(lru);

            return lru;
        }
    }
    public void updateFrequency(Node node){
        int freq = node.freq;
        DLL oldList = freqMap.get(freq);
        oldList.remove(node);

        if(freq == minFreq && oldList.size == 0){
            minFreq++;
        }

        node.freq++;
        freqMap.putIfAbsent(node.freq , new DLL());
        freqMap.get(node.freq).add(node);
    }
    HashMap<Integer , Node> map = new HashMap<>();
    HashMap<Integer , DLL> freqMap = new HashMap<>();
    int capacity;
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node curr = map.get(key);

        updateFrequency(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if(map.containsKey(key)){
            Node curr = map.get(key);
            curr.value = value;

            updateFrequency(curr);
            return;
        }

        if(map.size() == capacity){
            DLL minList = freqMap.get(minFreq);
            Node curr = minList.removeLast();
            map.remove(curr.key);
        }
        Node newNode = new Node(key , value);
        minFreq = 1;
        freqMap.putIfAbsent(1 , new DLL());
        freqMap.get(newNode.freq).add(newNode);
        map.put(key , newNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */