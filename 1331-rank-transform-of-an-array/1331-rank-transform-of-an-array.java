class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy=arr.clone();

        Arrays.sort(copy);
        int currRank=1;

        Map<Integer, Integer> map=new HashMap<>();

        for(int num:copy){
            if(!map.containsKey(num)){
                map.put(num, currRank++);
            }
        }

        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;


    }
}