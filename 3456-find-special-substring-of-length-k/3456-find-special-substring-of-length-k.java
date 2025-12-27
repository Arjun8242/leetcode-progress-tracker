class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int n=s.length();
        int ind=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)==s.charAt(ind)) continue;
            if(i-ind==k) return true;
            ind=i;
        }
        return (n-ind)==k;
    }
}