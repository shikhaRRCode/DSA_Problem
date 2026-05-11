class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i =  0 ; i < n ; i++){
            int num = nums[i];
            ArrayList<Integer> sublist = new ArrayList<>();
            while(num > 0){
                sublist.add(num%10);
                num/=10;
            }

            for(int k = sublist.size()-1 ; k >=0 ; k--){
                list.add(sublist.get(k));
            }
        }

        int[] ans = new int[list.size()];
        int i = 0;
        for(int val : list){
            ans[i] = val;
            i++;
        }
        return ans;
    }
}