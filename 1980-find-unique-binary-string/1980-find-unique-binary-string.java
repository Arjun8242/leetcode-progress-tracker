class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        boolean[] seen = new boolean[1 << n];

        for(String s : nums){
            int num = Integer.parseInt(s, 2);
            seen[num] = true;
        }

        for(int i = 0; i < (1 << n); i++){
            if(!seen[i]){
                String bin = Integer.toBinaryString(i);

                while(bin.length() < n){
                    bin = "0" + bin;
                }

                return bin;
            }
        }

        return "";
    }
}