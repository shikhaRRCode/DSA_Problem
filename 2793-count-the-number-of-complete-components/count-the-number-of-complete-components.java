class Solution {
    int vertexCount , edgeCount;
    public int countCompleteComponents(int n, int[][] edges) {
        // build adjacency list
        List<List<Integer>> graph = buildGraph(edges , n);

        int countComponents = 0;
        boolean[] visited = new boolean[n];
        // traverse every connected component
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                // reset counts for current component
                vertexCount = 0 ; edgeCount = 0;
                DFS(i , visited , graph);

                // complete graph: edges = V * (V-1) / 2
                if(edgeCount/2 == (vertexCount * (vertexCount-1))/2){
                    countComponents++;
                }
            }
        }
        return countComponents;
    }
    public void DFS(int node , boolean[] visited , List<List<Integer>> graph){
        visited[node] = true;
        // count current vertex
        vertexCount++;
        // add all edges of current vertex
        edgeCount += graph.get(node).size();

        for(int neigh : graph.get(node)){
            if(!visited[neigh]){
                DFS(neigh , visited , graph);
            }
        }
    }
    public List<List<Integer>> buildGraph(int[][] edges , int n){
        List<List<Integer>> graph = new ArrayList<>();

        //Initialize graph
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            int u = e[0] , v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}