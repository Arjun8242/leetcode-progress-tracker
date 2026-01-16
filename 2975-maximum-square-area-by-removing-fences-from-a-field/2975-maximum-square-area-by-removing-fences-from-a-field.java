class Solution {
    static final long mod=1_000_000_007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int[] H=new int[hFences.length+2];
        int[] V=new int[vFences.length+2];
        Set<Integer> set=new HashSet<>();

        H[0]=1;
        H[H.length-1]=m;
        for(int i=0;i<hFences.length;i++){
            H[i+1]=hFences[i];
        }

        V[0]=1;
        V[V.length-1]=n;
        for(int i=0;i<vFences.length;i++){
            V[i+1]=vFences[i];
        }

        Arrays.sort(V);
        Arrays.sort(H);

        for(int i=0;i<H.length;i++){
            for(int j=i+1;j<H.length;j++){
                if(i!=j){
                    set.add(H[j]-H[i]);
                }
            }
        }

        int maxSqrLength=-1;
        for(int i=0;i<V.length;i++){
            for(int j=0;j<V.length;j++){
                if(i!=j){
                    if(set.contains(V[j]-V[i])){
                        maxSqrLength=Math.max(maxSqrLength, V[j]-V[i]);
                    }
                }
            }
        }

        if(maxSqrLength==-1) return -1;

        long sqrArea=(1L*maxSqrLength*maxSqrLength)%mod;
        return (int)sqrArea;

    }
}