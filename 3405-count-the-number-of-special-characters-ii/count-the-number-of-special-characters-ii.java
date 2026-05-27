class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for(int i = 0 ; i < n ; i++){
            if(word.charAt(i) - 'a' >= 0 && word.charAt(i) - 'a' < 26){
                lower[word.charAt(i) - 'a'] = true;

                if(upper[word.charAt(i) - 'a']){
                    lower[word.charAt(i) - 'a'] = false;
                }
            }

            if(word.charAt(i) - 'A' >= 0 && word.charAt(i) - 'A' < 26){
                upper[word.charAt(i) - 'A'] = true;
            }
        }

        int count = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(lower[i] && upper[i]){
                count++;
            }
        }
        return count;
    }
}