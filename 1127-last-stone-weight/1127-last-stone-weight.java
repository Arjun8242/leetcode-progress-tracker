class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->b-a);
        for(int i:stones)
        heap.add(i);

        while(heap.size()>1){
            int first=heap.poll();
            int second=heap.poll();
            int diff=Math.abs(first-second);

            if(diff!=0){
                heap.add(diff);
            }
        }
        if(heap.size()!=0) return heap.poll();
        else return 0;
    }
}