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
    public ListNode swapPairs(ListNode head) 
    {
        if(head == null || head.next == null)
        {
            return head;
        }    

        return swap(head , head.next);
    }
    public ListNode swap(ListNode prev , ListNode curr)
    {
        ListNode temp = curr.next;

        // swap current pair
        curr.next = prev;

        // connect with next swapped pair
        if(temp != null && temp.next != null){
            prev.next = swap(temp , temp.next);
        }
        else{
            prev.next = temp;
        }

        return curr;
    }
}