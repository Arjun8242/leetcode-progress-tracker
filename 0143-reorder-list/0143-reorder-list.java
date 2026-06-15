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
        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode reverse=slow.next;
        slow.next=null;

        ListNode prev=null;

        while(reverse!=null){
            ListNode next=reverse.next;
            reverse.next=prev;
            prev=reverse;
            reverse=next;
        }
        reverse=prev;

        ListNode merge=head;

        while(reverse!=null){
            ListNode temp1=merge.next;
            ListNode temp2=reverse.next;

            merge.next=reverse;
            reverse.next=temp1;

            merge=temp1;
            reverse=temp2;

        }
        
    }
}