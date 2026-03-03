class Solution {
    public char findKthBit(int n, int k) {
        //Base case
        if(n == 1){
            return '0';
        }

        //finding Length of Sn string
        int length = (1 << n) - 1;   //Math.pow(2,n) 

        if(k < Math.ceil(length/2.0)){
            return findKthBit(n-1 , k);
        }  
        else if(k ==  Math.ceil(length/2.0)){
            return '1';
        }
        else{
            char ch = findKthBit(n-1 , length - (k - 1));   //handled reversed

            //handled flipped(invert)
            return ch == '0' ? '1' : '0';
        }
    }//T.C = O(n) , S.C = O(n)
}