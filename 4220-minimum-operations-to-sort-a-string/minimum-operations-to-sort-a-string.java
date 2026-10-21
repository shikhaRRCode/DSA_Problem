class Solution {
    public int minOperations(String s) {
        int n = s.length();

        boolean flag = true;
        char min_char = 'z' , max_char = 'a';
        int min_idx = 0 , max_idx = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) < min_char){
                min_char = s.charAt(i);
                min_idx = i;
            }

            if(s.charAt(i) >= max_char){
                max_char = s.charAt(i);
                max_idx = i;
            }

            if(flag && i != 0){
                if(s.charAt(i) < s.charAt(i-1)){
                    flag = false;
                }
            }
        } 

        if(flag){
            return 0;
        }  
        else if(n < 3){
            return -1;
        }
        else if(min_idx == n-1  && max_idx == 0){
            return 3;
        }
        else if(min_idx == 0 || max_idx == n-1){
            return 1;
        }
        else{
            return 2;
        }
    }
}