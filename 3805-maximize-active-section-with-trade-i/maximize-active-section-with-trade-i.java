class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        ArrayList<Integer> zeroBlocks = new ArrayList<>();

        int count0 = 0;
        int count1 = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '0'){
                count0++;
            }
            else{
                count1++;
                if(count0 > 0){
                    zeroBlocks.add(count0);
                    count0 = 0;
                }
            }

        }
        if(count0 > 0){
            zeroBlocks.add(count0);
        }


        if(zeroBlocks.size() <= 1){
            return count1;
        }
        int max = 0;
        for(int i = 0 ; i < zeroBlocks.size() - 1 ; i++){
            max = Math.max(max , zeroBlocks.get(i) + zeroBlocks.get(i+1));
        }
        return count1 + max;
    }
}