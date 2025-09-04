class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int maxlen=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                maxlen=Math.max(i-j+1, maxlen);
            }
            else{
                while(set.contains(s.charAt(i))){
                    set.remove(s.charAt(j));
                    j++;
                }
                set.add(s.charAt(i));
            }

        }
        return maxlen;
    }
}