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
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        int[] ans = new int[]{Integer.MAX_VALUE, -1};
        int first_crit_idx = -1;
        int crit_idx = -1;
        int count = 2;

        while (next != null) {
            // Check for local maxima or local minima
            if ((prev.val > curr.val && next.val > curr.val) || 
                (prev.val < curr.val && next.val < curr.val)) {
                
                if (first_crit_idx == -1) {
                    // First critical point found
                    first_crit_idx = count;
                } else {
                    // Subsequent critical points: calculate distances
                    ans[0] = Math.min(ans[0], count - crit_idx);          // Min distance (adjacent)
                    ans[1] = Math.max(ans[1], count - first_crit_idx);   // Max distance (first to current)
                }
                crit_idx = count;
            }

            count++;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if (ans[0] == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return ans;
    }
}