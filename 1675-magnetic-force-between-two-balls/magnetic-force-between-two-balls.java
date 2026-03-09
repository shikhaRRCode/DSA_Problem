class Solution {
    public int maxDistance(int[] position, int m) 
    {
        int n = position.length;
        Arrays.sort(position);
        int start = 1;
        int end = position[n-1] - position[0]; 
        int mid , ans=0;

        while(start <= end){
            // try this minimum distance
            mid =(start + end)/2;
            int count = 1 ;               // first ball placed at first position
            int force = position[0];      // last placed ball position
            // greedily place next balls if distance >= mid
            for(int i = 0 ; i < n ; i++){

                if(position[i] - force >= mid){
                    count++;                    
                    force = position[i];        
                }
            }
            // if we cannot place m balls → distance too large
            if(count < m){
                end = mid - 1;
            }
            else{
                // distance possible, try to increase it
                ans = mid;
                start = mid + 1;
            }
        } 
        return ans;  
    }
}