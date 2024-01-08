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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // find the length of the list
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len +=1;
            temp = temp.next;
        }

        // find the index of the node that you want to remove
        int index = len - n;

        // if the index is 0, set head = head.next
        if (index == 0) {
            head = head.next;
            return head;
        }
        else {
            ListNode temp1 = head;
            int count = 1;
            while (count < index) {
                temp1 = temp1.next;
                count += 1;
            }
            temp1.next = temp1.next.next;
        }
        return head;
    }
}


/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }


 /*
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Create a temporary node and a counter to find the length of the linked list
        ListNode temp = head;
        int count = 0;

        // Traverse the linked list and count the number of nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Calculate the index of the node to be removed from the beginning of the list
        int len = count - n;

        // If the first node needs to be removed, update the head and return
        if (len == 0) {
            head = head.next;
        } 
        else {
             // Traverse the list until the node before the one to be removed
            ListNode prev = head;
            while (len - 1 != 0) {
                prev = prev.next;
                len--;
            }
        // Remove the node by updating the previous node's next pointer
        prev.next = prev.next.next;
        }

    // Return the head node of the modified list
    return head;
    }
}
*/

