class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int key = i+j;
                map.putIfAbsent(key , new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }   

        boolean flip = true;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int k = 0 ; k <= m+n-2 ; k++)
        {
            List<Integer> diagonal = map.get(k);

            if(flip){
                Collections.reverse(diagonal);
            }
            ans.addAll(diagonal);

            flip = !flip;
        }

        int[] arr = new int[ans.size()];
        int idx = 0;
        for(int val : ans){
            arr[idx++] = val;
        }
        return arr;
    }
}