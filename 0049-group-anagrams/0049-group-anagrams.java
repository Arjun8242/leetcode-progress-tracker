class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagram=new ArrayList<>();
        Map<String, List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            if(!map.containsKey(String.valueOf(ch))){
                map.put(String.valueOf(ch),new ArrayList<>());
            }
            map.get(String.valueOf(ch)).add(s);
        }
        return new ArrayList<>(map.values());
        }
    }