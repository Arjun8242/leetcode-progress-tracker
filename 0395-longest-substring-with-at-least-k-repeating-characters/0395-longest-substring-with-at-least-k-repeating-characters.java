class Solution {
    public int longestSubstring(String s, int k) {
     int n=s.length();
     Map<Character, Integer> map=new HashMap<>();
     for(char ch:s.toCharArray()){
        map.put(ch,map.getOrDefault(ch,0)+1);
    }   
    for(char ch:map.keySet()){
        if(map.get(ch)<k){
            int max=0;
            for(String str:s.split(String.valueOf(ch))){
                max=Math.max(max,longestSubstring(str,k));
            }
            return max;
        }
    }
    return n;
    }
}