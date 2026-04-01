class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];

        // store indices (to sort based on positions)
        for(int i = 0 ; i < n ; i++){
            indices[i] = i;
        }
        //custom sorting: sort robots by position (left → right)
        Arrays.sort(indices , (i,j) -> Integer.compare(positions[i],positions[j]));


        Stack<Integer> st = new Stack<>();             // stores indices of robots
        for(int idx : indices){
            char currDir = directions.charAt(idx);

            // if moving right → just push
            if (currDir == 'R') {
                st.push(idx);
            } else {             // current robot moving left
               // fight with previous robots in stack
                while (!st.isEmpty()) {

                    int top = st.peek();
                    // if top robot stronger → current dies
                    if (healths[top] > healths[idx]) {
                        healths[top]--;
                        healths[idx] = 0;
                        break;
                    } 
                    // equla -> both dies
                    else if (healths[top] == healths[idx]) {
                        healths[top] = 0;
                        healths[idx] = 0;
                        st.pop();
                        break;
                    } 
                    // current stronger → top dies, continue fighting
                    else {
                        healths[top] = 0;
                        st.pop();
                        healths[idx]--;

                    }
                }
            }    
        }
        // collect surviving robots (health > 0)
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(healths[i] != 0){
                ans.add(healths[i]);
            }
        }
        return ans;
    }
}