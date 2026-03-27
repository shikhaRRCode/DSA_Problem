class Solution {

    //Tire Creation
    static class Node{
        Node[] children;
        boolean eow;
        String word;

        Node(){
            this.children = new Node[26];
            for(int i = 0 ; i < 26 ; i++){
                children[i] = null;
            }
            this.eow = false;
            this.word = "";
        }
    }
    static Node root;
    //Insert in Trie
    public static void insert(String word){
        Node crawler = root;
        for(int i = 0 ; i < word.length() ; i++){
            int idx = word.charAt(i) - 'a';

            if(crawler.children[idx] == null){
                crawler.children[idx] = new Node();
            }

            //Go to next level
            crawler = crawler.children[idx];
        }
        crawler.eow = true;
        crawler.word = word;
    }
// -----------------------------------------------------------------------------------------------------------
    int[] row = {-1 , 1 , 0 , 0};
    int[] col = {0 , 0 , -1 , 1};
    public void DFS(int i , int j , char[][] grid , Node root){

        if(root.children[grid[i][j] - 'a'] == null){
            return;
        }

        root = root.children[grid[i][j] - 'a'];
        if(root.eow == true){
            ans.add(root.word);
            root.eow =false;
        }

        char temp = grid[i][j];
        grid[i][j] = '$';    //Mark visited
        for(int k = 0 ; k < 4 ; k++){
            if(isValid(i + row[k],j + col[k])  && grid[i+row[k]][j+col[k]] != '$'){
                DFS(i + row[k] , j + col[k] , grid , root);
            }
        }
        grid[i][j] = temp;    //backtrack(mark unvisited)
    }
    public boolean isValid(int i ,  int j){
        return i >= 0 && j >= 0 && i < n && j < m;
    }

// -----------------------------------------------------------------------------------------------------------
    int n , m;
    List<String> ans = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {         //Main function
        //1. Insert words to find in a TRIE
        root = new Node();
        for(int x = 0 ; x < words.length ; x++){
            insert(words[x]);
        }

        n = board.length;
        m = board[0].length;
        //2. Traverse in grid(just once) and find all the words in trie if present
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                char ch = board[i][j];

                if(root.children[ch - 'a'] != null){
                    DFS(i , j , board , root);
                }
            }
        }

        return ans;
    }
}