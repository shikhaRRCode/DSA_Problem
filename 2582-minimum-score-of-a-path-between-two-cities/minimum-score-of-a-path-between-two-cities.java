class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : roads){
            int u = e[0]-1 , v = e[1]-1 , w = e[2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }

        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        //node , cost
        q.add(new int[]{0,0});
        visited[0] = true;

        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] top = q.poll();
            int node = top[0];
           
            for(int[] pair : graph.get(node)){
                int cost = pair[1];
                int neigh = pair[0];
                ans = Math.min(ans , cost);

                if(!visited[neigh]){
                    q.add(new int[]{neigh , cost});
                    visited[neigh] = true;
                }
            }

        }
        return ans;

    }
}
