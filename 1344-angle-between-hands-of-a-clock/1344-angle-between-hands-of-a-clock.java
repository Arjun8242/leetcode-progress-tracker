class Solution {
    public double angleClock(int hour, int minutes) {
        double hourangle=0;
        if(hour==12) hourangle=0;
        else{
            hourangle=hour*30;
        }
        hourangle+=minutes*0.5;

        double minuteangle=minutes*6;

        double diff=Math.abs(hourangle-minuteangle);

        return Math.min(diff, 360-diff);
    }
}