class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();

        Stack<Integer> st = new Stack<>();
        int score = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '('){  //fresh start
                st.push(score);
                score = 0;
            }
            else if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    score = st.peek() +1;
                }
                else{  //nested case
                    score =st.peek() + (score*2);
                }

                st.pop();
            }
        }
        return score;
    }
}