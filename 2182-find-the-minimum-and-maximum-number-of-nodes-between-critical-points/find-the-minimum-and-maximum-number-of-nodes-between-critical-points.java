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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        int[] ans = new int[2];
        ans[0] = Integer.MAX_VALUE;

        int first_crit_idx = -1;
        boolean flag = true; 
        int crit_idx = -1;
        int count = 2;
        while(next != null){
            if((prev.val > curr.val && next.val > curr.val) || (prev.val < curr.val && next.val < curr.val)){
                if(crit_idx != -1){
                    ans[0] = Math.min(ans[0] , count - crit_idx);
                }

                if(first_crit_idx != -1){
                    ans[1] =Math.max(ans[1] , count - first_crit_idx);
                }

                if(flag){
                    first_crit_idx = count;
                    flag = false;
                }
                crit_idx = count;
            }

            count++;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if(ans[0] == Integer.MAX_VALUE){
            ans[0] = ans[1] = -1;
        }
        return ans;
    }
}