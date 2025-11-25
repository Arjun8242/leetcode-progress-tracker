class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();

        int left=0;
        StringBuilder curr=new StringBuilder();
        for(int right=0;right<s.length();right++){

            curr.append(s.charAt(right));

            if(right-left+1==10){
                String key=curr.toString();

                if(map.getOrDefault(key, 0) == 1) ans.add(key);

                map.put(key, map.getOrDefault(key, 0) + 1);

                curr.deleteCharAt(0);
                left++;
            }
        }

        // for (int i = 0; i <= s.length() - 10; i++) {
        //     String sub = s.substring(i, i + 10);
        //     map.put(sub, map.getOrDefault(sub, 0) + 1);
        //     if (map.get(sub) == 2) ans.add(sub); 
        // }
        // simple logic 
        // iterate from 0 to len-10
        // take substring of len 10 and check if it is present in map or not 
        // if present increase the count and store it in ans list

        return ans;
    }
}