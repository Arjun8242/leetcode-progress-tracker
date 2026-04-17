class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        Map<Integer, List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int min=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int rev=reverse(nums[i]);
            if(!map.containsKey(rev))continue;

            List<Integer> list=map.get(rev);
            int idx=up(list, i);
            if(idx!=-1){
                min=Math.min(min, list.get(idx)-i);
            }
        }
        return min==Integer.MAX_VALUE? -1 : min;
    }
    public int reverse(int num){
        int rev=0;
        while(num>0){
            rev=rev*10+num%10;
            num/=10;
        }
        return rev;
    }
    public int up(List<Integer> list, int x){
        int l=0;
        int r=list.size()-1;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(list.get(mid)>x){
                ans=mid;
                r=mid-1;
            } else{
                l=mid+1;
            }
        }
        return ans;
    }
}