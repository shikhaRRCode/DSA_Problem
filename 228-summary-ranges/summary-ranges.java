class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();

        int i = 0;
        while(i < n){
            int j = i+1;
            while(j < n){
                if((nums[j-1]+1) != nums[j]){
                    break;
                }
                j++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            if(j-1 != i){
                sb.append("->");
                sb.append(nums[j-1]);
            }
            i = j;
            ans.add(sb.toString());
        }
        return ans;
    }
}