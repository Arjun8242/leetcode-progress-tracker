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
        int len=0;
        ListNode trav=head;
        while(trav!=null){
            trav=trav.next;
            len++;
        }
        if(n==len){
            return head.next;
        }
        int pos=len-n;
        int link=1;
        ListNode curr=head;
        while(link<pos){
            curr=curr.next;
            link++;
        }
        curr.next=curr.next.next;
        return head;
    }
}