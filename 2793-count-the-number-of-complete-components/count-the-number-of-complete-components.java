class Solution {
    int vertexCount , edgeCount;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = buildGraph(edges , n);

        int countComponents = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                vertexCount = 0 ; edgeCount = 0;
                DFS(i , visited , graph);

                if(edgeCount/2 == (vertexCount * (vertexCount-1))/2){
                    countComponents++;
                }
            }
        }
        return countComponents;
    }
    public void DFS(int node , boolean[] visited , List<List<Integer>> graph){
        visited[node] = true;
        vertexCount++;
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