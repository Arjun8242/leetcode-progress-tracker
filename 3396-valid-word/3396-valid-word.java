class Solution {
    public boolean isValid(String word) {
        int len=word.length();
        if(len<3) return false;
        int vowel=0;
        int consonant=0;
        for(char c: word.toCharArray()){
            if(Character.isLetter(c)){
                if("aeiouAEIOU".indexOf(c)!=-1) vowel++;
                else consonant++;
            }
            else if(!Character.isDigit(c)) return false;
        }
        return vowel>=1 && consonant>=1;
    }
}