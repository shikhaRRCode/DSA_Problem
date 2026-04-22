class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {

        ArrayList<String> ans = new ArrayList<>();
        for(String que : queries){
            for(String dict : dictionary){
                int diff = 0;
                for(int i = 0 ; i < dict.length() ; i++){
                    if(que.charAt(i) != dict.charAt(i)){
                        diff++;
                    }

                    if(diff > 2){
                        break;
                    }
                }

                if(diff <= 2){
                    ans.add(que);
                    break;
                }
            }
        }
        return ans;
    }
}// here , dict[i] == que[i] == n (all are of same length)