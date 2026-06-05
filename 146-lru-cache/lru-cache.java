class LRUCache {
    // stores {key, value} pairs
    ArrayList<int[]> cache = new ArrayList<>();
    int n;
    public LRUCache(int capacity) {
        n = capacity;
    }

    public int get(int key) {
        // search key in cache
        for(int i = 0 ; i < cache.size() ; i++){
            // key found
            if(cache.get(i)[0] == key){
                // make it most recently used
                int[] temp = new int[]{cache.get(i)[0] , cache.get(i)[1]};
                cache.remove(i);
                cache.add(temp);

                // return value
                return temp[1];
            }
        }
        // key not present
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0 ; i < cache.size() ; i++){
            // if key already exists
            if(cache.get(i)[0] == key){
                // remove old entry
                cache.remove(i);

                // add updated entry at end
                // (most recently used)
                cache.add(new int[]{key,value});
                return;
            }
        }
        // cache full -> remove least recently used item
        if(cache.size() == n){
            cache.remove(0);
        }
        // add new item as most recently used
        cache.add(new int[]{key , value});
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */