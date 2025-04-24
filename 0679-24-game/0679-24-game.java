class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums=new ArrayList<>();
        for(int card:cards){
            nums.add((double)card);
        }
        return backtrack(nums);
    }
    boolean backtrack(List<Double> nums){
        if(nums.size()==1){
            return Math.abs(nums.get(0)-24)<1e-6;//base case forr recursion
        }
        for(int i =0;i<nums.size();i++){
            for(int j=0;j<nums.size();j++){
                if(i!=j){
                    List<Double> next=new ArrayList<>();
                    for(int k=0;k<nums.size();k++){
                        if(k!=i && k!=j){
                            next.add(nums.get(k));//add 3rd element into next list then after sometime add result of operations of a and b in this list
                        }
                        }
                        double a=nums.get(i), b=nums.get(j);
                        List<Double> results=new ArrayList<>();
                        results.add(a+b);
                        results.add(a-b);
                        results.add(b-a);
                        results.add(a*b);
                        if(Math.abs(b)>1e-6)results.add(a/b);
                        if(Math.abs(a)>1e-6)results.add(b/a);
                        for(double result:results){
                            next.add(result);
                            if(backtrack(next))return true;
                            next.remove(next.size()-1);
                        }

                    }
                }
            }
            return false;
        }
    }
