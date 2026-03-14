class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder();
        String[] result = {""};     //(to store kth string) Using an array to pass by reference
        int[] count = {0};          //to keep track of kth string

        solve(n , curr , k , count ,  result);

        return result[0];
    }
    public void solve(int n ,  StringBuilder curr , int k , int[] count ,  String[] result ){
        if(curr.length() == n){
            count[0]++;

            if(count[0] == k)
            {
                result[0] = curr.toString();
            }
            return;
        }

        for(char ch = 'a' ; ch <= 'c' ; ch++){
            if(curr.length() > 0 && curr.charAt(curr.length()-1) == ch){
                continue;
            }

            //Do
            curr.append(ch);

            //Explore
            solve(n , curr , k , count , result);

            //Undo
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
// T.C : O(n * 3 * 2^(n-1)) ~= O(n*2^n)  ------> n for storing string in list
// S.C : O(n) by recursion system stack