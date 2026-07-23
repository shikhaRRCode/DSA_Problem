class Solution {
    public String reverseVowels(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        int i = 0 , j = n-1;
        while(i < j){
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(j);

            if(!checkVowel(ch1)){
                i++;
            }
            else if(!checkVowel(ch2)){
                j--;
            }
            else{
                char temp = ch1;
                sb.setCharAt(i , ch2);
                sb.setCharAt(j , temp);

                i++;
                j--;
            }

        }
        return sb.toString();
    }
    public boolean checkVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}