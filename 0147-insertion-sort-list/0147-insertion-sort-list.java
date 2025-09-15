class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;
            ListNode next = curr.next;

            // find the correct position for curr
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // insert curr
            curr.next = prev.next;
            prev.next = curr;

            curr = next;
        }

        return dummy.next;
    }
}
