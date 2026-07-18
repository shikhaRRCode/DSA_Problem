class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int smallest = nums[0];
        int largest = nums[0];
        for(int i = 0 ; i < n; i++){
            smallest = Math.min(smallest , nums[i]);
            largest = Math.max(largest , nums[i]);
        }

        //GCD
        int HCF = 1;
        for(int i = Math.min(smallest , largest) ; i >= 1 ; i--){
            if(smallest % i == 0 && largest % i == 0){
                HCF = i;
                break;
            }
        }
        return HCF;
    }
}