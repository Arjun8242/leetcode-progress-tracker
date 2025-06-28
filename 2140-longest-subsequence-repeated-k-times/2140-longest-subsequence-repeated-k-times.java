class Solution {
        public String longestSubsequenceRepeatedK(String s, int k) {
        String ans = "";
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String next = curr + ch;
                if (isrepeated(next, s, k)) {
                    ans = next;
                    queue.add(next);
                }
            }
        }
        return ans;
    }

        boolean isrepeated(String pattern, String s, int k){
        int i=0;
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch==pattern.charAt(i)){
                i++;
                if(i==pattern.length()){
                    i=0;
                    count++;
                    if(count==k) return true;
                }
            }
        }
        return false;
    }


    //THIS IS A BFS APPROACH
    


       /* Map<Character,Integer> freq=new HashMap<>();
        for(char ch:s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        StringBuilder valid=new StringBuilder();
        for(char ch='a'; ch<='z'; ch++){
            if(freq.getOrDefault(ch, 0)>=k)
            valid.append(ch);
        }
        String validchars=valid.toString();
        String res="";

        for(int len=7; len>=1; len--){
            List<String> candidates=new ArrayList();
            generate(validchars, "", len, candidates);
            candidates.sort(Collections.reverseOrder());

            for(String cand:candidates){
                if(isrepeated(cand, s, k))
                return cand;
            }
        }
        return "";
    }

    public static void generate(String chars, String curr, int len, List<String> res){
        if(curr.length()==len){
            res.add(curr);
            return;
        }

        for(int i=0;i<chars.length();i++){
            generate(chars, curr+chars.charAt(i), len, res);
        }
    }

    boolean isrepeated(String pattern, String s, int k){
        int i=0;
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch==pattern.charAt(i)){
                i++;
                if(i==pattern.length){
                    i=0;
                    count++;
                    if(count==k) return true;
                }
            }
        }
        return false;
    }  */   // THIS IS A DFS APPROACH

     
}