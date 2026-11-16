class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        
        while (sb.length() > k) {
            StringBuilder temp = new StringBuilder();
            int sum = 0;
            int c = 0;
            
            for (int i = 0; i < sb.length(); i++) {
                if (c == k) {
                    temp.append(sum);
                    sum = 0;
                    c = 0;
                }
                sum += sb.charAt(i) - '0';
                c++;
            }
            // Append the sum of the last remaining group
            temp.append(sum); 
            sb = temp;
        }
        
        return sb.toString();
    }
}