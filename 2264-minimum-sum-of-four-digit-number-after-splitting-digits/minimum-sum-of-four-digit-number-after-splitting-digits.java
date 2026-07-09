class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];
        
        // Extract all 4 digits
        for (int i = 0; i < 4; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(digits);

        int num1 = digits[0] * 10 + digits[3];
        int num2 = digits[1] * 10 + digits[2];

        return num1 + num2;
    }
}