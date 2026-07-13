class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        String s="123456789";
        int n=s.length();

        for(int i=1;i<=n;i++){
            int l=0;
            int r=i;

            while(r<10){
                int num = Integer.parseInt(s.substring(l, r));
                if(num>=low && num<=high){
                    ans.add(num);
                }
                l++;
                r++;
            }
        }

        

        return ans;
    }
}