class Solution {
    public double angleClock(int hour, int minutes) {
        double minAngle = minutes * 6;
        double hourAngle = hour * 30;
        double relation = minAngle / 12;

        double angle1 = Math.abs(minAngle - hourAngle - relation);
        double angle2 = 360 - angle1;

        return Math.min(angle1 , angle2); 
    }
}
// 1 min = 6 deg
// 5 min = 30 deg
// 1 hr = 30 deg

// 60 min = 1 hr
// 360 deg = 30 deg
// 1deg = 30 % 360 = 1/12

// 3 * 30 = 90, 180
