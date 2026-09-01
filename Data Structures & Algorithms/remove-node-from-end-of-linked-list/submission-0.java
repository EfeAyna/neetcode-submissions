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


        if(head == null) return null;
        
        ListNode n1 = head;
        ListNode n2 = head.next;

        int length = 0;

        while(n1 != null){
            n1 = n1.next;
            length++;
        }

        int nFB = length - n;

        n1 = head;

        if(nFB == 0){
            return head.next;
        }

        while(nFB != 1){
            n1 = n1.next;
            n2 = n2.next;
            nFB--;
        } 

        n1.next = n2.next;
        n2.next = null;

        return head; 


        

    }
}
