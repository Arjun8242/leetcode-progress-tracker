class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        // for(int i=0;i<n;i++){
        //     if(letters[i]>target) return letters[i];
        // }
        // return letters[0];

        int low=0;
        int high=n-1;
        int mid;
        int ans=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(letters[mid]>target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans==-1?letters[0]:letters[ans];
    }
}