class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) 
    {
        int n = asteroids.length;
        Arrays.sort(asteroids);

        long currmass = mass;
        for(int i  = 0 ; i < n ; i++){
            if(currmass >= asteroids[i]){
                currmass += asteroids[i];
            }
            else{
                return false;
            }

        }
        return true;
    }
}