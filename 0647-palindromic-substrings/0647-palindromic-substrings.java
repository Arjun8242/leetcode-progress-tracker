class Solution {
    public int countSubstrings(String s) {
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String sub = s.substring(i, j + 1);

            if (isbinpal(sub)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isbinpal(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}