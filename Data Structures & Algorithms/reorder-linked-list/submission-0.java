class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Find middle of the linked list using slow/fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);
        
        // Break the link between first half and second half
        slow.next = null;

        // 3. Merge the two halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode next1 = firstHalf.next;
            ListNode next2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = next1;

            firstHalf = next1;
            secondHalf = next2;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}