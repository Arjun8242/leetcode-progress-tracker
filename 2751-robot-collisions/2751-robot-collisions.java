class Solution {
    static class Robot{
        int pos, health, ind;
        char dirs;
        Robot(int pos, int health, int ind, char dirs){
            this.pos=pos;
            this.health=health;
            this.ind=ind;
            this.dirs=dirs;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n=healths.length;
        Robot[] robot=new Robot[n];
        for(int i=0;i<n;i++){
            robot[i]=new Robot(positions[i], healths[i], i, directions.charAt(i));
        }

        Arrays.sort(robot, (a, b) ->
            a.pos - b.pos
        );

        Stack<Robot> stack=new Stack<>();

        for(Robot curr:robot){
            if(curr.dirs=='R'){
                stack.push(curr);
            }
            else{
                while(!stack.isEmpty() && stack.peek().dirs=='R' && curr.health>0){
                    Robot top=stack.peek();

                    if(top.health<curr.health){
                        stack.pop();
                        curr.health-=1;
                    }
                    else if(top.health>curr.health){
                        top.health-=1;
                        curr.health=0;
                        break;
                    }
                    else{
                        stack.pop();
                        curr.health=0;
                        break;
                    }
                }

                if(curr.health>0){
                    stack.push(curr);
                }
            }
        }
        List<Robot> remaining=new ArrayList<>(stack);
        remaining.sort((a, b) -> a.ind-b.ind);

        List<Integer> result=new ArrayList<>();

        for(Robot x:remaining){
            result.add(x.health);
        }
        
        return result;
    }
}