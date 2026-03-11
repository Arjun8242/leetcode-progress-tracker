class Solution {
    public int bitwiseComplement(int n) {

        if(n==0) return 1;
        
        StringBuilder binary = new StringBuilder();

        int temp = n;
        while (temp > 0) {
            binary.append(temp % 2);
            temp /= 2;
        }

        binary.reverse();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0')
                binary.setCharAt(i, '1');
            else
                binary.setCharAt(i, '0');
        }

        int result = 0;
        int power = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                result += Math.pow(2, power);
            }
            power++;
        }

        return result;
    }
}