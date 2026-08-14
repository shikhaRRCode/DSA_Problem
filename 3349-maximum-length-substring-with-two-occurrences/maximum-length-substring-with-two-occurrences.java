class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();

        HashMap<Character , Integer> map = new HashMap<>();
        int maxLen = 0;
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            int val = map.getOrDefault(s.charAt(i) , 0);
            map.put(s.charAt(i) , val+1);

            while(map.get(s.charAt(i)) > 2){
                map.put(s.charAt(j) , map.get(s.charAt(j)) - 1);
                j++;
            }

            maxLen = Math.max(maxLen , i-j+1);
        }
        return maxLen;
    }
}