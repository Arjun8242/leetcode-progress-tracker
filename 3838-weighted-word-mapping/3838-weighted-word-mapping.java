class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result=new StringBuilder();

        for(String w:words){
            int tot=0;
            for(int i=0;i<w.length();i++){
                char ch=w.charAt(i);
                tot+=weights[ch-'a'];
            }
            int ans=tot%26;
            char newword=(char)('z'-ans);

            result.append(newword);
        }
        return result.toString();
    }
}