class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        //mapping a , b, c;
        int[] map = new int[3];
        int result = 0;

        int left = 0;
        for(int right = 0 ; right < n ; right++){
            map[s.charAt(right) - 'a']++;

            while(check(map)){
                result += n-right;
                map[s.charAt(left) - 'a']--;
                left++;
            }

        }
        return result;
    }
    public boolean check(int[] map){
        return map[0] > 0 && map[1] > 0 && map[2] > 0; 
    }
}