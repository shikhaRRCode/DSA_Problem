class Solution {
    public String addBinary(String a, String b) 
    {
        int n = a.length()-1;
        int m = b.length()-1;

        StringBuilder ans = new StringBuilder();
        char carry = '0';
        while(n >= 0 || m >= 0)
        {
            char first = n < 0 ? '0' : a.charAt(n);
            char second = m < 0 ? '0' : b.charAt(m);

            if(first == '1' && second == '1' && carry == '1'){
                ans.append(1);
                carry = '1'; 
            }
            else if((first == '1' && second == '1' && carry == '0')  || (first == '1' && second == '0' && carry == '1') || (first == '0' && second == '1' && carry == '1')){
                ans.append(0);
                carry ='1';
            }
            else if((first == '0' && second == '0' && carry == '1') || (first == '0' && second == '1' && carry == '0') || (first == '1' && second == '0' && carry == '0')){
                ans.append(1);
                carry = '0';
            }
            else if((first == '0' && second == '0' && carry == '0') ){
                ans.append(0);
                carry = '0';
            }
            n--;m--;
        }
        //Add final carry
        if(carry == '1'){
            ans.append(1);
        }

        return ans.reverse().toString();
    }
}