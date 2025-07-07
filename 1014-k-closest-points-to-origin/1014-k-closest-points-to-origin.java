class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap=new PriorityQueue<>(
            (a,b)->distance(b)-distance(a)
        );

        for(int[] point:points){
            heap.add(point);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[][]result=new int[k][2];
        int ind=0;
        while(!heap.isEmpty()){
            result[ind++]=heap.poll();
        }
        return result;
    }
    public int distance(int[] a){
        return a[0]*a[0]+a[1]*a[1];
    }

}