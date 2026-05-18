class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        // store: value -> all indexes having that value
        HashMap<Integer,ArrayList<Integer>> map= new HashMap<>();  
        boolean[] visited = new boolean[n];

        //build map
        for(int i = 0 ;  i < n ; i++){
            if(!map.containsKey(arr[i])){   
                map.put(arr[i] , new ArrayList<>());
            }

            map.get(arr[i]).add(i);
        }

        // BFS queue stores indexes
        Queue<Integer> q = new LinkedList<>();
        q.add(0);                           // start from index 0
        visited[0] = true;

        int steps = 0;
        // BFS traversal
        while(!q.isEmpty()){

            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();

                if(curr == n-1){
                    return steps;
                }

                // move left
                int left = curr-1;
                if(left >= 0 && !visited[left]){
                    q.add(left);
                    visited[left] = true;
                }

                // move right
                int right = curr+1;
                if(right < n && !visited[right]){
                    q.add(right);
                    visited[right] = true;
                }

                // jump to all indexes having same value
                if (map.containsKey(arr[curr])) {
                    for (int next : map.get(arr[curr])) {
                        if (next != curr && !visited[next]) {
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }    
               // remove processed value to avoid repeated work
                map.remove(arr[curr]);
            }
            // one BFS level completed
            steps++;
        }
        return -1;
    }
}