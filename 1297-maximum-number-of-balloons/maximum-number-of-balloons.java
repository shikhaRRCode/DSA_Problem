class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        int[] freq = new int[26];
        for(int i = 0 ; i < n ; i++){
            freq[text.charAt(i) - 'a']++;
        }   

        int count = Integer.MAX_VALUE;
        count = Math.min(count , freq[1]);
        count = Math.min(count , freq[0]);
        count = Math.min(count , freq[11]/2);
        count = Math.min(count , freq[14]/2);
        count = Math.min(count , freq[13]);

        return count;
    }
}