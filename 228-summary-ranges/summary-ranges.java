class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();

        int i = 0;
        while(i < n){
            // find the end of the current consecutive range
            int j = i+1;
            while(j < n){
                if((nums[j-1]+1) != nums[j]){
                    break;
                }
                j++;
            }
            // build the range string
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            // if range has more than one element, append "->end"
            if(j-1 != i){
                sb.append("->");
                sb.append(nums[j-1]);
            }
            // move to the next range
            i = j;
            ans.add(sb.toString());
        }
        return ans;
    }
}