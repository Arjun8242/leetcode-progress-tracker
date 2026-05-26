class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> lower=new HashSet<>();
        Set<Character> upper=new HashSet<>();
        int unique=0;

        for(char ch:word.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower.add(ch);
            }
            else{
                upper.add(Character.toLowerCase(ch));
            }
        }

        for(char ch:lower){
            if(upper.contains(ch)) unique++;
        }
        return unique;
    }
}