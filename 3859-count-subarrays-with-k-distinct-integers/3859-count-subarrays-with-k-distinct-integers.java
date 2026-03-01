class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int n=nums.length;
        int left=0;
        int countAtleastM=0;
        int distinct=0;
        long ans=0;
        long validprefixes=0;
        Map<Integer, Integer> map=new HashMap<>();

        for(int right=0;right<n;right++){
            int x=nums[right];
            map.put(x, map.getOrDefault(x,0)+1);
            if(map.get(x)==m) countAtleastM++;

            while(map.size()>k){
                int leftval=nums[left];
                if(map.get(leftval)==m) countAtleastM--;

                map.put(leftval, map.get(leftval)-1);

                if(map.get(leftval)==0) map.remove(leftval);

                left++;
                validprefixes=0;
            }

            if(countAtleastM==k){
                ans++;
                while(map.get(nums[left])>m){
                    int leftval=nums[left];
                    map.put(leftval, map.get(leftval)-1);
                    left++;
                    validprefixes++;
                }
                ans+=validprefixes;
            }
        }
        return ans;
    }
}