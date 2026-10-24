class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int startAlice = convertToDayOfYear(arriveAlice);
        int endAlice = convertToDayOfYear(leaveAlice);
        int startBob = convertToDayOfYear(arriveBob);
        int endBob = convertToDayOfYear(leaveBob);
        
        int overlapStart = Math.max(startAlice, startBob);
        int overlapEnd = Math.min(endAlice, endBob);
        
        if (overlapStart <= overlapEnd) {
            return overlapEnd - overlapStart + 1;
        }
        
        return 0;
    }
    private int convertToDayOfYear(String date) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonths[i];
        }
        
        return dayOfYear;
    }
}