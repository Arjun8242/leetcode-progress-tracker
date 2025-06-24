class Solution {
    public int numJewelsInStones(String jewels, String stones) {
       /* Map<String, Integer> jewel=new HashMap<>();
        for(int i=0;i<jewels.length();i++){
            char ch=jewels.charAt(i);
            jewel.put(String.valueOf(ch),0);
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
             char ch=stones.charAt(i);
             if(jewel.containsKey(String.valueOf(ch))){
                count++;
             }
        }*/   
        //for the set soln 
        Set<Character> jewelSet = new HashSet<>();
        
        for (char ch : jewels.toCharArray()) {
            jewelSet.add(ch);
        }

        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (jewelSet.contains(ch)) {
                count++;
            }
        }
        return count;
    }
}