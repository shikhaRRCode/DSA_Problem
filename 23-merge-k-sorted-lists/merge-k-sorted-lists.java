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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        int n = lists.length;

        // Min-heap to always pick smallest node among all
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val - b.val);

        // Push only head from every list into priority queue
        for(int i=0;i < n ; i++)                             //O(klogk)
        {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        // Pop nodes one by one from heap (in sorted order) and build list
        while(!pq.isEmpty())                                //O(nklogk)
        {
            ListNode ptr = pq.remove();
            temp.next = ptr;
            temp = temp.next;

            if(ptr.next != null){
                pq.add(ptr.next);
            }
        }
        temp.next = null;             // mark end of list
        return dummy.next;
    }
}                                                  //T.C = O(nklogk)   ,S.C = O(n)