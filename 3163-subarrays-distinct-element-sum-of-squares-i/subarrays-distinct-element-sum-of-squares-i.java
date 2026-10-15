class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            boolean[] freq = new boolean[101];
            int currCount = 0;
            for(int j = i ; j < n ; j++){
                if(!freq[nums.get(j)]){
                    freq[nums.get(j)] = true;
                    currCount++;
                }
                count += (currCount * currCount);
            }
        }
        return count;
    }
}