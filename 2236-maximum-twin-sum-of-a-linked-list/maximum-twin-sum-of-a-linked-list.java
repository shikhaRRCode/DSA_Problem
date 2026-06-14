/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) 
    {
        //step : 1 Finding mid node
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //step : 2 reversing second half of linked list
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //step :3 comparing twin nodes
        ListNode front = head;
        ListNode rear = prev;
        int maxSum = 0;
        while(rear != null){
            int twinSum = front.val + rear.val;
            maxSum = Math.max(maxSum , twinSum);

            front = front.next;
            rear = rear.next;
        }
        return maxSum;
    }
}