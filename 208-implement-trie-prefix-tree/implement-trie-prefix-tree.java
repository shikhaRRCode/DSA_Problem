class Trie {
    class Node{
        Node[] children;
        boolean eow;

        Node(){
            this.children = new Node[26];
            for(int i = 0 ; i < 26 ; i++){
                children[i] = null;
            }
            this.eow = false;
        }
    }
    //Root Node (Empty Node)
    Node root = new Node();

    public void insert(String word) {
        Node curr = root;

        for(int i = 0 ; i < word.length() ; i++)
        {
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){
                //add new node
                curr.children[idx] = new Node();
            }
            //if we reach end , mark eow = true
            if(i == word.length() - 1){
                curr.children[idx].eow = true;
            }

            //go to next level
            curr = curr.children[idx];
        }
    }
    
    public boolean search(String word) {
        Node curr = root;

        for(int i = 0 ; i < word.length() ; i++){
            int idx = word.charAt(i) - 'a';

            //if character doesn't exist
            if(curr.children[idx] == null){
                return false;
            }

            //if we reach end but end-of-word was not marked true
            if(i == word.length()-1 && curr.children[idx].eow == false){
                return false;
            }

            //go to next level
            curr = curr.children[idx];
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {

        Node curr = root;
        for(int i = 0 ; i < prefix.length() ; i++){
            int idx = prefix.charAt(i) - 'a';

            //if prefix doesn't exist
            if(curr.children[idx] == null){
                return false;
            }

            //go to next level
            curr = curr.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */