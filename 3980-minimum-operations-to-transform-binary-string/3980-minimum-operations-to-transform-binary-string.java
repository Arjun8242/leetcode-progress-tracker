class Solution {
    public int minOperations(String s1, String s2) {
        int n=s1.length();
        int ans=0;

        if(n==1){
            if(s1.charAt(0)=='1' && s2.charAt(0)=='0') return -1;
            else if(s1.charAt(0)=='0' && s2.charAt(0)=='1') return 1;
            else return 0;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) continue;

            if (a[i] == '0' && b[i] == '1') {
                a[i] = '1';
                ans++;
            } else if (a[i] == '1' && b[i] == '0') {
                if (i + 1 < n && a[i + 1] == '1') {
                    ans++;
                    a[i] = '0';
                    a[i + 1] = '0';
                } else if (i + 1 < n && a[i + 1] == '0') {
                    ans += 2;
                    a[i] = '0';
                    a[i + 1] = '0';
                } else {
                    ans += 2;
                }
            }
        }

        return ans;

    }
}