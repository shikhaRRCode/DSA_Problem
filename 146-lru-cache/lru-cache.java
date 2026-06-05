class LRUCache {
    ArrayList<int[]> cache = new ArrayList<>();
    int n;
    public LRUCache(int capacity) {
        n = capacity;
    }

    public int get(int key) {
        for(int i = 0 ; i < cache.size() ; i++){
            if(cache.get(i)[0] == key){
                int[] temp = new int[]{cache.get(i)[0] , cache.get(i)[1]};
                cache.remove(i);
                cache.add(temp);
                return temp[1];
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0 ; i < cache.size() ; i++){
            if(cache.get(i)[0] == key){
                cache.remove(i);
                cache.add(new int[]{key,value});
                return;
            }
        }

        if(cache.size() == n){
            cache.remove(0);
        }
        cache.add(new int[]{key , value});
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */