class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '['){
                st.push(ch);
            }
            else if(!st.isEmpty()){
                st.pop();
            }
        }
        return (st.size() + 1)/2;
    }
}