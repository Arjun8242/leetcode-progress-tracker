class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        int n=events.length,days=0,count=0,i=0;

        while(!heap.isEmpty() || i<n){
            if(heap.isEmpty()){
            days=events[i][0];
            }

            while(i<n && events[i][0]<=days){
                heap.offer(events[i][1]);
                i++;
            }

             heap.poll();
                days++;
                count++;

            while(!heap.isEmpty() && heap.peek() < days){
                heap.poll();
            }

        }
        return count;
    }
}