class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] C = new int[n];

        //Elements are in range 1 - n
        boolean isPresentA[] = new boolean[n+1];
        boolean isPresentB[] = new boolean[n+1];

        for(int i = 0 ; i < n ; i++){
            isPresentA[A[i]] = true;
            isPresentB[B[i]] = true;
            int count = 0;
            for(int j = 1 ; j <= n ; j++){
                if(isPresentA[j] && isPresentB[j]){
                    count++;
                }
            }
            C[i] = count;
        }
        return C;
    }
}