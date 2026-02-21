class Solution {
    public boolean hasAlternatingBits(int n) {
         while (n > 0) {
            int last = n & 1;
            int secondLast = (n >> 1) & 1;
            
            if (last == secondLast && n > 1) {
                return false;
            }
            
            n >>= 1;
        }
        return true;
    }
}