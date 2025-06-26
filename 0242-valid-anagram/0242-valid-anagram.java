class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        char[] ch1=t.toCharArray();
        Arrays.sort(ch1);
        if(String.valueOf(ch).equals(String.valueOf(ch1))) return true;
        return false;
    }
}