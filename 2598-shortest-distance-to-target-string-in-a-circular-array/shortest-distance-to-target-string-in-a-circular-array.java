class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int front = (startIndex+1)%n;
        int back = (startIndex-1+n)%n ;

        int ans = -1;
        int count = 1;

        if(target.equals(words[startIndex])){
            return 0;
        }
        while(back  != front){
            if(target.equals(words[back])  || target.equals(words[front]) ){
                ans = count;
                break;
            }
            count++;

            front = (front+1)%n;
            back = (back-1+n)%n;
        }
        if(target.equals(words[back])  || target.equals(words[front]) ){
            ans = count;
        }

        return ans;
    }
}