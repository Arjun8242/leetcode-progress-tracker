class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        // key insight is for a nums of len n>=3, I can generate 0 by 1^2^3 and i can generate that number by x^x^y so for a given len n all n numbers+0 which makes it n+1 nums is possible 

        //for a nums len=4 in binary 100, we can get total 7 unique 7 in binary is 111. so approach is take the length, convert in binary string and change all bits to 1 and convert back to integer thats your answer 

        if(n==1) return 1;
        if(n==2) return 2;

        String binary=Integer.toBinaryString(n);
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<binary.length();i++){
            sb.append('1');
        }

        return Integer.parseInt(sb.toString(), 2)+1;
        
    }
}