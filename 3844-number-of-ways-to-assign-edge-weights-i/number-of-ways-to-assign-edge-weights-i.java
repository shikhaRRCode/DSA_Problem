class Solution {
    static final long MOD = 1000000007L;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length+1;
        List<List<Integer>> graph = new ArrayList<>();
        // Number of nodes is edges.length + 1
        for(int i= 0 ; i <= n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0] , v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int maxDepth = findDepth(graph , 1 , -1);

        return (int)power(2 , maxDepth-1);
    }
    public int findDepth(List<List<Integer>> graph , int node , int parent){
        int depth = 0;
        for(int neigh : graph.get(node)){
            if(neigh == parent){
                continue;
            }

            depth = Math.max(depth , findDepth(graph , neigh , node) + 1);

        }
        return depth;
    }
    private long power(long base, long exponent) {
        if (exponent == 0)
            return 1;

        long half = power(base, exponent / 2);
        long result = (half * half) % MOD;

        if (exponent % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }
}