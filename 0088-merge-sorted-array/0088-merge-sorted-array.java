class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,k=0;
        int[] storage=new int [m+n];
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                storage[k]=nums1[i];
                i++;
                k++;
            }
            else {
                storage[k]=nums2[j];
                j++;
                k++;
            }
        }
        while(i<m){
            storage[k]=nums1[i];
            k++;
            i++;
        }
        while(j<n){
            storage[k]=nums2[j];
            k++;
            j++;
        }
        for(i=0;i<m+n;i++){
            nums1[i]=storage[i];
        }
    }
}