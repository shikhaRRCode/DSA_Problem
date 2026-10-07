class Solution {
    int n;
    private int maxLen;
    HashSet<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        set.clear();
        maxLen = 0;

        StringBuilder curr = new StringBuilder();
        solve(s , 0 , curr , 0 );

        return new ArrayList<>(set);
    }
    public void solve(String s , int i , StringBuilder curr , int count){
        // More ')' than '(' is invalid, prune this branch
        if(count < 0){
            return;
        }

        // Base case: processed all characters
        if(i == n){
            if(count == 0){
                if(curr.length() > maxLen){
                    maxLen = curr.length();
                    set.clear();
                }

                if(maxLen == curr.length()){
                    set.add(curr.toString());
                }
            }
            return;
        }

        // If current character is a letter, just add it
        if(s.charAt(i) != '(' && s.charAt(i) != ')'){
            curr.append(s.charAt(i));
            solve(s , i+1 , curr , count);
            curr.deleteCharAt(curr.length()-1);
            return;
        }

        // if current character is parentheses
        // take
        curr.append(s.charAt(i));
        solve(s , i+1 , curr , s.charAt(i) == '(' ? count+1 : count-1);
        curr.deleteCharAt(curr.length()-1);

        //skip
        solve(s , i+1 , curr , count);
    }
}