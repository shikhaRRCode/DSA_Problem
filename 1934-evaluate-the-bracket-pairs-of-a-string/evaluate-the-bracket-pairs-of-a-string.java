class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();

        Map<String , String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0) , list.get(1));
        }

        boolean isBracketOpen = false;
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new  StringBuilder();
        for(int i =  0 ; i < n ; i++){
            char c = s.charAt(i);
            if(c == '('){
                isBracketOpen = true;
            }
            else if(c == ')'){
                isBracketOpen = false;


                result.append(map.containsKey(temp.toString()) ? map.get(temp.toString()) : "?");
                temp.setLength(0);
            }
            else if(isBracketOpen){
                temp.append(c);
            }
            else{
                result.append(c);
            }

        }
        return result.toString();
    }

}