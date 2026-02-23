class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        double total=Math.pow(2, k);
        int n=s.length();

        for(int i=0;i<=n-k;i++){
            String sb=s.substring(i, i+k);
            set.add(sb);
            if(total==set.size()) return true;
        }    
        return total==set.size();
    }
}