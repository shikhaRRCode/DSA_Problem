class Solution {
    public boolean isPossible(int[] target) {
        //MAX-Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        long sum = 0 ;

        for(int i = 0 ; i < target.length ; i++){
            pq.offer(target[i]);
            sum+= target[i];
        }

        long remSum , maxEle , element;
        // keep reducing until all elements become 1
        while(pq.peek() != 1){
            maxEle = pq.poll();           // largest element
            remSum = sum - maxEle;       // sum of remaining elements

            //Edge Cases
            if(remSum >= maxEle || remSum <= 0){
                return false;
            }

            // optimized reverse step using modulo
            element = maxEle % remSum;
            if(element == 0){
                if(remSum != 1){
                    return false;
                }
                else{
                    return true;        //only possible case
                }
            }

            pq.add((int)element);                   //push back updated value
            sum = remSum + element;            //update sum
        }

        return true;
    }
}