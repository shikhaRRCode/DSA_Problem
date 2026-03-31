class Solution {
    public int[] smallestRange(List<List<Integer>> nums) 
    {
        //Min-Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int min;
        int max = Integer.MIN_VALUE;

         // insert first element of each list (row, col info also stored)
        for(int i = 0 ; i < nums.size() ; i++){
     
            pq.add(new int[]{nums.get(i).get(0) , i , 0});
            max = Math.max(max , nums.get(i).get(0));           // track current max
        }
        min = pq.peek()[0];

        // initial range
        int[] res = new int[2];
        res[0] = min;
        res[1] = max;


        // process until one list gets exhausted(finished)
        while(pq.size() == nums.size()){
            int[] curr = pq.poll();
            int ele = curr[0];
            int row = curr[1];
            int col = curr[2];

            // process until one list gets exhausted
            if(col+1 < nums.get(row).size()){
                pq.add(new int[]{nums.get(row).get(col+1) , row , col+1});
                max = Math.max(max , nums.get(row).get(col+1));
                min = pq.peek()[0];

                //If I have got smallest range
                if(max - min < res[1] - res[0]){
                    res[0] = min;
                    res[1] = max;
                }
            }
        }

        return res;
    }
} 