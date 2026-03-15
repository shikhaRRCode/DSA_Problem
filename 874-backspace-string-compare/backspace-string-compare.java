class Solution {
    public boolean backspaceCompare(String s, String t) 
    {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();   

        int n = s.length();
        int m = t.length();
        for(int i = 0 ; i < n ; i++)
        {
            char ch = s.charAt(i);
            if(ch == '#')                        // backspace → remove last charc
            {
                if(!st1.isEmpty()) st1.pop();
            }
            else    st1.push(ch);                // push normal character
        }
        for(int i = 0 ; i < m ; i++)
        {
            char ch = t.charAt(i);
            if(ch == '#')                        // backspace → remove last char
            {
                if(!st2.isEmpty()) st2.pop();
            }
            else    st2.push(ch);                // push normal character
        }

        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st1.pop() != st2.pop()){
                return false;
            }
        }

        return st1.isEmpty() && st2.isEmpty();
    }
}