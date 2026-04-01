class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];

        for(int i = 0 ; i < n ; i++){
            indices[i] = i;
        }
        //custom sorting:
        Arrays.sort(indices , (i,j) -> Integer.compare(positions[i],positions[j]));


        Stack<Integer> st = new Stack<>();
        for(int idx : indices){
            char currDir = directions.charAt(idx);

            if (currDir == 'R') {
                st.push(idx);
            } else {
                // currDir == 'L'
                while (!st.isEmpty() && directions.charAt(st.peek()) == 'R') {

                    int top = st.peek();

                    if (healths[top] > healths[idx]) {
                        healths[top]--;
                        healths[idx] = 0;
                        break;
                    } 
                    else if (healths[top] == healths[idx]) {
                        healths[top] = 0;
                        healths[idx] = 0;
                        st.pop();
                        break;
                    } 
                    else {
                        healths[top] = 0;
                        st.pop();
                        healths[idx]--;

                    }
                }
            }    
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(healths[i] != 0){
                ans.add(healths[i]);
            }
        }
        return ans;
    }
}