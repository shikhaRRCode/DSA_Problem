class Solution {

    //Implementing Trie
    class trieNode{
        trieNode[] children;    // stores next characters
        boolean eow;            // marks end of word

        trieNode(){
            children = new trieNode[26];   // for 'a' to 'z'
            for(int i = 0 ; i < 26 ; i++){
                children[i] = null;
            }
            eow = false;
        }
    }
    trieNode root = new trieNode();
    //Trie Insert
    public void insert(String word){
        trieNode curr = root;
        for(int i = 0 ; i < word.length() ; i++){
            int idx = word.charAt(i) - 'a';

            // create node if not present
            if(curr.children[idx] == null){
                curr.children[idx] = new trieNode();
            }

            // mark end of word
            if(i == word.length()-1){
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];         //move forward
        }
    }


    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict)   //Given function by leetcode
    {
        // Step 1: Insert all words into Trie
        for(int i = 0 ; i < wordDict.size() ; i++)
        {
            insert(wordDict.get(i));
        }

        // Step 2: Call recursive function
        dp = new Boolean[s.length()];
        return helper(s , 0);
    }
    // recursive + memo function
    public boolean helper(String s, int start) {
        // BASE CASE :reached end
        if(start == s.length()) return true;
        
        if(dp[start] != null) return dp[start];   // already computed

        trieNode node = root;

        for(int i = start; i < s.length(); i++) {

            char ch = s.charAt(i);
            int index = ch - 'a';

            // prefix not found in Trie
            if(node.children[index] == null) {
                return dp[start] = false;
            }

            // if valid word found, check remaining string
            node = node.children[index];

            if(node.eow && helper(s, i + 1)) {
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }
}