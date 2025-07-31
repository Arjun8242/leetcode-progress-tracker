class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result=new HashSet<>();
        Set<Integer> prev=new HashSet<>();
        for(int i:arr){
            Set<Integer> curr=new HashSet<>();
            curr.add(i);
            for(int j:prev){
                curr.add(i|j);
            }
            result.addAll(curr);
            prev=curr;
        }
        return result.size();
    }
}