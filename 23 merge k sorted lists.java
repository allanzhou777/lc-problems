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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode output = new ListNode(0);
        ListNode temp = output;
        int min;
        int minIndex;
        boolean empty = false;
        while (!empty) {
            empty = true;
            min = Integer.MAX_VALUE;
            minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    minIndex = i;
                    min = lists[i].val;
                    empty = false;
                }
            }
            
            if (!empty) {
                temp.next = new ListNode(lists[minIndex].val);
                temp = temp.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }
        return output.next;
        // every time you add the element of 
    }
}