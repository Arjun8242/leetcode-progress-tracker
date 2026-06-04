class Solution {
    public int totalWaviness(int num1, int num2) {
        int tot=0;

        if(num2<100) return 0;
        if(num1<100) num1=100;
        
        for(int i=num1;i<=num2;i++){
            String s=String.valueOf(i);
            int wave=0;
            for(int j=1;j<s.length()-1;j++){
                int prev=s.charAt(j-1)-'0';
                int curr=s.charAt(j)-'0';
                int next=s.charAt(j+1)-'0';

                if(curr>next && curr>prev) wave++;
                if(curr<next && curr<prev) wave++;
            }
            tot+=wave;
        }
        return tot;
    }
}