class Solution {

    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];

        return DFS(arr, start, visited);
    }

    public boolean DFS(int[] arr, int idx, boolean[] visited) {

        // out of bounds
        if(idx < 0 || idx >= arr.length){
            return false;
        }

        // already visited
        if(visited[idx]){
            return false;
        }

        // reached value 0
        if(arr[idx] == 0){
            return true;
        }

        // mark visited
        visited[idx] = true;

        // jump left or right
        return DFS(arr, idx + arr[idx], visited) ||
               DFS(arr, idx - arr[idx], visited);
    }
}