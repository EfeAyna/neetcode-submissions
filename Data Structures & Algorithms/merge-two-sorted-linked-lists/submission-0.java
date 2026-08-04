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
        if(list1 == null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode res = null;
        ListNode rP = null;

        if(list1.val < list2.val){
            p1 = list1.next;
            p2 = list2;
            res = list1;
            
        }
        else{
            p1 = list1;
            p2 = list2.next;
            res = list2;
            
        }
        rP = res;

        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                rP.next = p1;
                p1 = p1.next;
            }
            else{
                rP.next = p2;
                p2 = p2.next;
            }
            rP = rP.next;
        }

        while(p1 != null){
            rP.next = p1;
            p1 = p1.next;
            rP = rP.next;
        }

        while(p2 != null){
            rP.next = p2;
            p2 = p2.next;
            rP = rP.next;
        }

        return res;
    }
}