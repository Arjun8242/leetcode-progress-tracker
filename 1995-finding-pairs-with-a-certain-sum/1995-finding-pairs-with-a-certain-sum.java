class FindSumPairs {
    int[] n1,n2;
    Map<Integer,Integer> freq=new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        n1=nums1;
        n2=nums2;
        for(int i:n2) {
            freq.put(i,freq.getOrDefault(i,0)+1);
        }
        
    }
    
    public void add(int index, int val) {
        freq.put(n2[index],freq.get(n2[index])-1);
        n2[index]+=val;
        freq.put(n2[index],freq.getOrDefault(n2[index],0)+1);
        
    }
    
    public int count(int tot) {
        int c=0;
        for(int i:n1) c+=freq.getOrDefault(tot-i,0);
        return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */