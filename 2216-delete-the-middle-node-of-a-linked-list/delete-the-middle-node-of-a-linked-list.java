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
    public ListNode deleteMiddle(ListNode head) 
    {
        if (head.next == null) return null;  // Only one node, remove it

       int count = 0;
       ListNode ptr = head;
       //counting length of list
       while(ptr != null)
       {
           count++;
           ptr = ptr.next;
       }
       //finding middle element - 1
       count = count/2 - 1;
       ptr = head;
       while(count>0)
       {
           ptr = ptr.next;
           count--;
       }

       //deleting middle element
       ptr.next = ptr.next.next;
       return head;
    }
}