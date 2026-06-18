class Solution {
    public double angleClock(int hour, int minutes) {

        // minute hand moves 6° every minute
        double minAngle = minutes * 6;

        // hour hand moves 30° every hour
        double hourAngle = hour * 30;

        // hour hand also moves 0.5°(1/12) every minute
        double relation = minAngle / 12;

        // angle between hour and minute hands
        double angle1 = Math.abs(minAngle - hourAngle - relation);

        // angle in the opposite direction
        double angle2 = 360 - angle1;

        // return the smaller angle
        return Math.min(angle1, angle2);
    }
}

/*
Logic:

1 min  = 6°
1 hour = 30°

Hour hand also moves with minutes:
60 min = 1 hr
360 deg -> 30°
1 min  -> 0.5° (= 1/12 of minute hand angle)/-

Find the absolute angle between both hands,
then return the smaller of:
angle and (360 - angle).
*/
