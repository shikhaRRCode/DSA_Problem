class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        int max = 1;
        if(map.containsKey(1)){
            int val = map.get(1);
            if(val % 2 == 0){
                val--;
            } 
            max = Math.max(max , val);
        }

        for(int key : map.keySet()){
            if(key == 1){
                continue;
            }

            int currLen = 0;
            long curr = key;
            while(curr <= 1000000000L && map.getOrDefault((int)curr , 0) >= 2){
                currLen += 2;
                curr*=curr;
            }

            if(curr <= 1000000000L && map.getOrDefault((int)curr , 0) > 0){
                currLen++;
            }
            else{
                currLen--;
            }
            max = Math.max(max , currLen);
        }

        return max;
    }
}