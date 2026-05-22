class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        int n=nums1.length;

        for(int i=0;i<n;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                return nums2[i];
            }
        }
        return -1;
    }
}