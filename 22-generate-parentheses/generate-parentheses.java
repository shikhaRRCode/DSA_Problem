class Solution {
    public List<String> generateParenthesis(int n) 
    {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder("");

        solve(n, 0 , 0 , ans , temp);     

        return ans;
    }
    static void solve(int n , int left , int right , ArrayList<String> ans , StringBuilder temp)
    {
        // base case: valid parentheses string
        if(left == n && right == n)
        {
            ans.add(temp.toString());
            return;
        }

        // add '(' if possible
        if(left < n)
        {
            temp.append('(');
            solve(n, left + 1 , right , ans , temp );
            temp.deleteCharAt(temp.length() - 1);           // backtrack
        }

        // add ')' if possible
        if(right < left)
        {
            temp.append(')');
            solve(n, left , right + 1 , ans , temp);
            temp.deleteCharAt(temp.length() - 1);           // backtrack
        }
    }
}