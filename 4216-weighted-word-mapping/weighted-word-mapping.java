class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        int n = words.length;

        for(int i = 0 ; i < n ; i++){
            String word = words[i];
            int weight = 0;
            for(int j = 0 ; j < word.length() ; j++){
                weight += weights[word.charAt(j) - 'a'];
            }
            weight = weight % 26;
            char curr = (char)('z' - weight);
            ans.append(curr);
        }

        return ans.toString();
    }
}
