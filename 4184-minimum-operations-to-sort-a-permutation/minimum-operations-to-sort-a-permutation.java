class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int asc_count = 0;
        int dsc_count = 0;

        for(int i = 1; i < n; i++) {
            asc_count += (nums[i] == (nums[i-1]+1)%n) ? 1 : 0;
            dsc_count += (nums[i-1] == (nums[i]+1)%n) ? 1 : 0;
        }

        if(asc_count == n-1 && nums[0] == 0) { //0, 1, 2, .... n-1
            return 0;
        }

        if(asc_count == n-1) {
            int leftRot  = n - nums[0];
            int rightRot = 1 + (nums[n-1] + 1) + 1;
            return Math.min(leftRot, rightRot);
        }

        if(dsc_count == n-1) {
            //Mandatory 1 Reverse
            int leftRot = n - nums[n-1] + 1;

            //x Left Rot + 1 Reverse
            int rightRot = (nums[0]+1)%n + 1;

            return Math.min(leftRot, rightRot);
        }

        return -1;
    }
}
// Observation:
// reverse : can only change direction
// rotate by left : can change starting point

// ex : {4 , 0 , 1 , 2 , 3}
// assume in circle:
//          4
//     3        0
//             
//       2    1

//So , both operations doesnt modify array , i.e neighbours of a element remain same.
