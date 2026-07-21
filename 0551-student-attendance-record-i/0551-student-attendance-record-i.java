class Solution {
    public boolean checkRecord(String s) {
        int n=s.length();
        int Lcount=0;
        int Acount=0;

        for(int i=0;i<n;i++){

            // if(Lcount==3){
            //         return false;
            // }

            if(s.charAt(i)=='A'){
                Acount++;
                Lcount=0;
            }

            if(s.charAt(i)=='P'){
                Lcount=0;
            }

            if(s.charAt(i)=='L'){
                if(Lcount==2){
                    return false;
                }
                Lcount++;
            }
        }

        if(Acount>=2){
                return false;
        }

        return true;
    }
}