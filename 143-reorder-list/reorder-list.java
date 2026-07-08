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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode middle = middleNode(head); 

        ListNode tail = reverseHalf(middle);

        modifiedList(head , tail);
    }
    public ListNode middleNode(ListNode head){
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    public ListNode reverseHalf(ListNode middle){
        ListNode prev = null;
        ListNode curr = middle;
        while(curr != null){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void modifiedList(ListNode head , ListNode tail){
        while(tail != null && head != null){
            ListNode temp1 =  head.next;
            head.next = tail;

            ListNode temp2 = tail.next;
            tail.next = temp1 == null ? temp2 : temp1;

            head = temp1;
            tail = temp2;
        }
    }
}
//1 -> 2 -> 4    
//5 -> 4 -> 3 