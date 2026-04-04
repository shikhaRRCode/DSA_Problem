class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();

        int cols = n/rows;
        char[][] mat = new char[rows][cols];

        int idx = 0;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                mat[i][j] = encodedText.charAt(idx++);
            }
        }

        //Traversing diagonally 
        StringBuilder originalText = new StringBuilder();
        for(int c = 0 ; c < cols ; c++){
            int i = 0 ;
            int j = c;
            while(i < rows && j < cols){
                originalText.append(mat[i][j]);
                i++;
                j++;
            }
        }

        //removing trailing space
        int len = originalText.length()-1;
        while(len >= 0 && originalText.charAt(len)  == ' '){
            originalText.deleteCharAt(len);
            len--;
        }
        return originalText.toString();
    }
}