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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode curr=head;
        ListNode prevGroupEnd=dummy;

        while(curr!=null){
            ListNode kth=getKth(curr, k);
            if(kth==null) break;

            ListNode nextGroupStart=kth.next;
            ListNode prev=nextGroupStart;
            ListNode temp=curr;

            while(temp!=nextGroupStart){
                ListNode next=temp.next;
                temp.next=prev;
                prev=temp;
                temp=next;
            }

            prevGroupEnd.next=kth;
            prevGroupEnd=curr;
            curr=nextGroupStart;

        }
        return dummy.next;
    }
    public ListNode getKth(ListNode start, int k){
        while(start!=null && k>1){
            start=start.next;
            k--;
        }
        return start;
    }
}