class Solution 
{
    public int minMovesToSeat(int[] seats, int[] students) 
    {
        int n=seats.length;

        int[] seatsPos = new int[101];
        int[] studentsPos = new int[101];
        for(int seat : seats){
            seatsPos[seat]++;
        } 

        for(int student : students){
            studentsPos[student]++;
        }

        int i = 0 , j = 0;
        int minMoves=0;
        while(i <= 100 && j <= 100){
            if(seatsPos[i] == 0)  i++;

            if(studentsPos[j] ==0) j++;

            if(i <= 100 && j <= 100 && seatsPos[i] != 0 && studentsPos[j] != 0){
                minMoves += Math.abs(j-i);

                seatsPos[i]--;
                studentsPos[j]--;
            }
        }
        return minMoves;
    }
}