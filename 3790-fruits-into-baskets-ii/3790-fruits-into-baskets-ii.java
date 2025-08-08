class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced=0;
        boolean[] check=new boolean[fruits.length];
        for(int i=0;i<fruits.length;i++){
            boolean used=false;
            for(int j=0;j<baskets.length;j++){
                if(fruits[i]<=baskets[j] && !check[j]) {
                    check[j]=true;
                    used=true;
                    break;
                }
            }
        }
        for(int i=0;i<baskets.length;i++){
            if(!check[i]) unplaced++;
        }
        return unplaced;

    }
}