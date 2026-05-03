class Solution {
    public boolean rotateString(String s, String goal) 
    {
        String s1=s+s;
        if(s.length()==goal.length())
        {
            return s1.contains(goal);
        }
        else
        {
            return false;
        }    
    }
}
//this is leftshift