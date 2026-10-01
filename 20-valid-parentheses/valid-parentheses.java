class Solution {
    public boolean isValid(String s) 
    {
        Stack<Character> st = new Stack<>();   // stack to track opening brackets
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);        

            // push opening brackets onto stack
            if(ch == '(' || ch == '['  || ch =='{')
            {
                st.push(ch);
            }
            // if closing bracket matches top of stack → pop
            else if(!st.isEmpty() && ch == ')' && st.peek() =='(') 
            {
                st.pop();
            }
            else if(!st.isEmpty() && ch == ']' && st.peek() =='[')
            {
                st.pop();
            }
            else if(!st.isEmpty() && ch == '}' && st.peek() =='{')
            {
                st.pop();
            }
            // invalid case (closing bracket without match)
            else
            {
                return false;
            }
        }
        // valid only if all brackets matched (stack empty)
        return st.isEmpty(); 

    }
}