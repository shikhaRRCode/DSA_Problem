class Solution {
    public int largestAltitude(int[] gain) 
    {
        int n=gain.length;
        int height[]=new int[n+1];
        int max=height[0];
        for(int i=1;i<=n;i++)
        {
            height[i]=gain[i-1]+height[i-1];
            max=Math.max(max,height[i]);
        }
        return max;
    }
}