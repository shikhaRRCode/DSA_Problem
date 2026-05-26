class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        boolean[] freq1 = new boolean[26];
        boolean[] freq2 = new boolean[26];

        for(int i = 0 ; i < n ; i++){
            if(word.charAt(i) - 'a' >= 0 && word.charAt(i) - 'a' <=  26){
                freq1[word.charAt(i) - 'a'] = true;
            }

            if(word.charAt(i) - 'A' >= 0 && word.charAt(i) - 'A' <= 26){
                freq2[word.charAt(i) - 'A'] = true;
            }
        }

        int count = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(freq1[i] && freq2[i]){
                count++;
            }
        }   
        return count;
    }
}