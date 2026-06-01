class Solution {
    public int minimumCost(int[] cost) 
    {
        int n=cost.length;

        Arrays.sort(cost);
        int ans=0,count=1;

        for(int i=n-1;i>=0;i--)
        {
            
            if(count%3!=0)
            {
                ans+=cost[i];
                
            }
            count++;
        }   
        return ans; 
    }
}