class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        // store frequency of each number
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        int max = 1;
        // handle number 1 separately
        if(map.containsKey(1)){
            int val = map.get(1);
            if(val % 2 == 0){
                val--;
            } 
            max = Math.max(max , val);
        }

        // try every number as starting point
        for(int key : map.keySet()){
            if(key == 1){
                continue;
            }

            int currLen = 0;
            long curr = key;
            // keep moving to curr² while current number appears at least twice
            while(curr <= 1000000000L && map.getOrDefault((int)curr , 0) >= 2){
                currLen += 2;
                curr*=curr;
            }

            // last number can appear once
            if(curr <= 1000000000L && map.getOrDefault((int)curr , 0) > 0){
                currLen++;
            }
            else{
                // remove one extra count if chain breaks
                currLen--;
            }
            max = Math.max(max , currLen);
        }

        return max;
    }
}
/*
Logic:

1. Count frequency of every number.
2. Handle 1 separately (answer must be odd).
3. Start from each number.
4. Keep following: x -> x² -> x⁴ ...
5. Every intermediate number needs frequency >= 2.
6. Last number needs frequency >= 1.
7. Return the maximum valid chain length.
*/