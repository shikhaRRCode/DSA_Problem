class Solution {
    public int kthSmallest(int[][] matrix, int k) 
    {   
        int n = matrix.length;
        // Min-Heap  
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        //1. adding 1st column
        for(int i = 0 ; i < n ; i++){
            //                element , r_idx , col_idx
            pq.add(new int[]{matrix[i][0] , i , 0});
        }

        int element = 0;
        while(k-- > 0){
            element = pq.peek()[0];
            int row_idx = pq.peek()[1];
            int col_idx = pq.peek()[2];
            pq.poll();

            // 2. Only add the next element from the SAME row(next column)
            if(col_idx < n-1){
                pq.add(new int[]{matrix[row_idx][col_idx+1] , row_idx , col_idx+1});
            }
            
        }
         return element;
    }                           //T.C = O(klogn)
}