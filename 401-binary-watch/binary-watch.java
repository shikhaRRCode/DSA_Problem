class Solution {
    public List<String> readBinaryWatch(int turnedOn) 
    {
        ArrayList<String> ans = new ArrayList<>();
        for(int hh = 0 ; hh <= 11  ; hh++)
        {
            for(int mm = 0 ; mm <=59 ; mm++)
            {
                //counting set bit(means turned-on light)
                if(Integer.bitCount(hh)+Integer.bitCount(mm) == turnedOn)
                {
                    String hour = "" + hh;
                    String minutes = (mm < 10 ? "0" : "") + mm;

                    ans.add(hour + ":" + minutes);
                }
            }
        }    
        return ans;
    }
}