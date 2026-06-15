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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode mid=slow;

        if(head.next==null) return null;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            mid=slow;
            slow=slow.next;
        }
        mid.next=slow.next;

        return head;
    }
}