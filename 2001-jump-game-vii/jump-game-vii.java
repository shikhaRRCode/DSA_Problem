class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        //t[i] shows : ways to reach i(kya mai i tkk pahuch skta hu ,in how many ways)
        int[] t = new int[n];
        t[0] = 1;

        int count = 0;
        for(int j = 1 ; j < n ; j++){
            if(j - minJump >= 0){
                count += t[j-minJump];
            }

            if(j - maxJump - 1 >= 0){
                count -= t[j - maxJump - 1]; 
            }

            if(count > 0 && s.charAt(j) == '0'){
                t[j] = 1;
            }
        }
        return t[n-1] > 0;
    }
}