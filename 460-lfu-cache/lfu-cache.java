class LFUCache {

    // Node of DLL
    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    // DLL for each frequency
    class DLL {
        Node head, tail;
        int size;

        DLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // add node just after head (MRU)
        public void add(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // remove a node
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // remove LRU node of this frequency
        public Node removeLast() {
            if (size == 0) {
                return null;
            }

            Node lru = tail.prev;
            remove(lru);

            return lru;
        }
    }

    int capacity;
    int minFreq;

    // key -> node
    HashMap<Integer, Node> map;

    // frequency -> DLL
    HashMap<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    // increase frequency of a node
    private void updateFrequency(Node node) {

        int oldFreq = node.freq;

        DLL oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        // if minimum frequency list becomes empty
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.putIfAbsent(node.freq, new DLL());

        freqMap.get(node.freq).add(node);
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            updateFrequency(node);

            return;
        }

        // cache full
        if (map.size() == capacity) {

            DLL minFreqList = freqMap.get(minFreq);

            Node nodeToDelete = minFreqList.removeLast();

            map.remove(nodeToDelete.key);
        }

        Node newNode = new Node(key, value);

        minFreq = 1;

        freqMap.putIfAbsent(1, new DLL());

        freqMap.get(1).add(newNode);

        map.put(key, newNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */