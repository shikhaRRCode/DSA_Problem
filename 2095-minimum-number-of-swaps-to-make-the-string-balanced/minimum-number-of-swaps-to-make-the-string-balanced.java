class Solution {
    public int minSwaps(String s) {
        int n = s.length();

        int left = 0 , count = 0;
        for(char ch : s.toCharArray()){
            if(ch == '['){
                left++;
            }
            else{
                left--;
                if(left < 0){
                    count++;
                    left = 0;
                }
            }
        }
        return (count+1)/2;
    }
}