class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();

        Map<String , String> map = new HashMap<>();
        for(List<String> list : knowledge){
            map.put(list.get(0) , list.get(1));
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < n){
            char c = s.charAt(i);

            if(isAlpha(c)){
                result.append(c);
            }
            else{  //open bracket
                i++;
                StringBuilder temp = new StringBuilder();
                while(i < n && s.charAt(i) != ')'){
                    temp.append(s.charAt(i));

                    i++;
                }

                if(map.containsKey(temp.toString())){
                    result.append(map.get(temp.toString()));
                }
                else{
                    result.append("?");
                }

            }
            i++;

        }
        return result.toString();
    }
    public boolean isAlpha(char c){
        return c >= 97 && c <= 122;
    }
}