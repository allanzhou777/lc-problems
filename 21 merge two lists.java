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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode out = new ListNode(0);
        ListNode head = out;
        while (temp1 != null && temp2 != null) {
            int data;
            if (temp1.val > temp2.val) {
                data = temp2.val;
                temp2 = temp2.next;
            }
            else {
                data = temp1.val;
                temp1 = temp1.next;
            }
            out.next = new ListNode(data);
            out = out.next;
        }

        ListNode end = (temp1 == null) ? temp2 : temp1;
        while (end != null) {
            out.next = new ListNode(end.val);
            out = out.next;
            end = end.next;
        }
        return head.next;
    }
}