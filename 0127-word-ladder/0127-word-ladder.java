class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        Queue<String> queue=new LinkedList<>();
        int len=1;
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String word=queue.poll();
                if(word.equals(endWord)) return len++;
                char[] arr=word.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char ch=arr[j];
                    for(char c='a';c<='z';c++){
                        arr[j]=c;
                        String newword=new String(arr);
                        if(set.contains(newword)){
                            set.remove(newword);
                            queue.offer(newword);
                        }
                    }
                    arr[j]=ch;
                }
            }
            len++;
        }
        return 0;
    }
}