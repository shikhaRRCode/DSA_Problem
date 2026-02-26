class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;

        while (!sb.toString().equals("1")) {

            // If even (last bit 0) → divide by 2
            if (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            }
            else {
                // If odd → add 1
                int i = sb.length() - 1;

                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }

                if (i >= 0) {
                    sb.setCharAt(i, '1');
                } else {
                    sb.insert(0, '1');
                }
            }

            count++;
        }

        return count;
    }
}