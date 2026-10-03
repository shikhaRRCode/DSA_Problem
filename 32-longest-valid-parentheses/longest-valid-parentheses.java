class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int maxLen = 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);   // Base index for boundary calculation

        for(int i = 0 ; i < n; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);  // Reset base index on invalid ')'
                }
                else{
                    maxLen = Math.max(maxLen , i - st.peek());
                }
            }
        }
        return maxLen;
    }
}