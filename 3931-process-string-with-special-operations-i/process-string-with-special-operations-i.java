class Solution {
    public String processStr(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0 ; i < n ; i++){
            char curr = s.charAt(i);
            if(curr == '*'){
                if( result.length() == 0)    continue;

                result.deleteCharAt(result.length()-1);
            }
            else if(curr == '#'){
                if( result.length() == 0)    continue;

                result.append(result);
            }
            else if(curr == '%'){
                if( result.length() == 0)    continue;
                
                result.reverse();
            }
            else{
                result.append(curr);
            }
        }
        return result.toString();
    }
    
}