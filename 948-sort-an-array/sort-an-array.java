class Solution {
    public int[] sortArray(int[] nums) 
    {
        int n = nums.length;

        //1. Build MaxHeap
        buildMaxHeap(nums , n);
        //2. Sort an Array
        sortArray(nums , n);

        return nums;
    }
    public void buildMaxHeap(int[] nums , int n){
        //Step-down
        for(int i = n/2 - 1 ; i >=0 ; i--){
            Heapify(nums , i , n);
        } 
    }
    public void sortArray(int[] nums , int n){
        
        for(int i = n-1 ; i > 0 ; i--){
            //1. swap the max-node with last Heap node
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            //2. Heapified for i size
            Heapify(nums , 0 , i);
        }
    }
    public void Heapify(int[] nums , int idx , int n){
        while(true){
            int largest = idx;
            int left = 2*idx +1;
            int right = 2*idx + 2;

            if(left < n && nums[left] > nums[largest]){
                largest = left;
            }
            if(right < n && nums[right] > nums[largest]){
                largest = right;
            }


            if(largest == idx)   break;          //already Heapified

            //swap
            int temp = nums[idx];
            nums[idx] = nums[largest];
            nums[largest] = temp;


            idx = largest;    //move down
        }
    }
}