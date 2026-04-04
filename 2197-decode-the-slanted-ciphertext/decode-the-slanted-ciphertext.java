class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();

        int cols = n/rows;
        StringBuilder originalText = new StringBuilder();
        for(int c = 0 ; c < cols ; c++){
            for(int j = c ; j < n ; j+=cols+1){
                originalText.append(encodedText.charAt(j));
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