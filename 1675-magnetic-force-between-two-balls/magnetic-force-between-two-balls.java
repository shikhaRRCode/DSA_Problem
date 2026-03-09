class Solution {
    public int maxDistance(int[] position, int m) 
    {
        int n = position.length;
        Arrays.sort(position);
        int start = 1;
        int end = position[n-1] - position[0]; 
        int mid , ans=0;

        while(start <= end){
            mid =(start + end)/2;
            int count = 1 , force = position[0];
            for(int i = 0 ; i < n ; i++){

                if(position[i] - force >= mid){
                    count++;
                    force = position[i];
                }
            }
            if(count < m){
                end = mid - 1;
            }
            else{
                ans = mid;
                start = mid + 1;
            }
        } 
        return ans;  
    }
}