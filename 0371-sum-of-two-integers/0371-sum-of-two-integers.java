class Solution {
    public int getSum(int a, int b) {
        // b=-b;
        // return a-b;
    //     while (b > 0) {
    //     a++;
    //     b--;
    // }

        while(b!=0){
            int carry=a & b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }
}