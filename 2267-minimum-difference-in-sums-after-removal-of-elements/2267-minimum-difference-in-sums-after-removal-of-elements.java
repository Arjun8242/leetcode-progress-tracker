class Solution {
    public long minimumDifference(int[] nums) {
        int n=nums.length/3;
        long[] leftsum=new long[nums.length];
        long[] rightsum=new long[nums.length];
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        
        long currleftsum=0;
        for(int i=0;i<n;i++){
            currleftsum+=nums[i];
            maxheap.offer(nums[i]);
        }
        leftsum[n-1]=currleftsum;

        for(int i=n;i<2*n;i++){
            currleftsum+=nums[i];
            maxheap.offer(nums[i]);
            currleftsum-=maxheap.poll();
            leftsum[i]=currleftsum;
        }

        long currrightsum=0;
        for(int i=nums.length-1;i>=2*n;i--){
            minheap.offer(nums[i]);
            currrightsum+=nums[i];
        }

        rightsum[2*n]=currrightsum;

        for(int i=2*n-1;i>=n;i--){
            minheap.offer(nums[i]);
            currrightsum+=nums[i];
            currrightsum-=minheap.poll();
            rightsum[i]=currrightsum;
        }

        long mindiff=Long.MAX_VALUE;
        for(int i=n-1;i<2*n;i++){
            long diff=leftsum[i]-rightsum[i+1];
            mindiff=Math.min(diff,mindiff);
        }

        return mindiff;
        
    }
}