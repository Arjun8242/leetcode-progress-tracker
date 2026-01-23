class Solution {
    public int jump(int[] nums) {
        // int n=nums.length;
        // boolean[] vis=new boolean[n];
        // Queue<int[]> q=new LinkedList<>();
        // q.offer(new int[]{0,0});
        // vis[0]=true;

        // while(!q.isEmpty()){
        //     int[] curr=q.poll();
        //     int idx=curr[0];
        //     int jumps=curr[1];

        //     if(idx==n-1) return jumps;
            
        //     int maxjumps=nums[idx];
        //     for(int i=1;i<=maxjumps;i++){
        //         int nxtidx=idx+i;
        //         if(nxtidx<n && !vis[nxtidx]){
        //             vis[nxtidx]=true;
        //             q.offer(new int[]{nxtidx, jumps+1});
        //         }
        //     }
        // }
        // return -1;

        int n=nums.length;
        int jumps=0;
        int farthestEnd=0;
        int currEnd=0;

        for(int i=0;i<n-1;i++){
            farthestEnd=Math.max(farthestEnd, i+nums[i]);

            if(i==currEnd){
                jumps++;
                currEnd=farthestEnd;
            }
        }
        return jumps;
    }
}