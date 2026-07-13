class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 1 ; i <= 9 ; i++){
            int seqDigit = 0;
            for(int j = i ; j <= 9 ; j++){
                seqDigit = (seqDigit * 10) + j;

                if(seqDigit > high){
                    break;
                }

                if(seqDigit >= low){
                    ans.add(seqDigit);
                }

            }
        }
        Collections.sort(ans);
        return ans;
    }
}