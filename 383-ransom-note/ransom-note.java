class Solution {
    public boolean canConstruct(String ransomNote, String magazine) 
    {
        int n = ransomNote.length();
        int m = magazine.length();

        if(n > m){
            return false;
        }    
        HashMap<Character , Integer> map = new HashMap<>();
        for(char val : ransomNote.toCharArray()){
            map.put(val , map.getOrDefault(val , 0) + 1);
        }

        for(char val : magazine.toCharArray()){
            if(map.containsKey(val)){
                int freq = map.get(val);
                if(freq == 1){
                    map.remove(val);
                }    
                else{
                    map.put(val , freq-1);
                }
            }
        }

        return map.size() == 0;
    }
}