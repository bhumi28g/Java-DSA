public class removeNthFromEnd {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {

            int cnt = 0;
            ListNode temp = head;

            // Count nodes
            while (temp != null) {
                cnt++;
                temp = temp.next;
            }

            if (n > cnt) {
                return head;
            }

            // If removing the first node
            if (n == cnt) {
                return head.next;
            }

            temp = head;
            int i = 1;

            // Reach node just before the node to delete
            while (temp != null && i + n < cnt) {
                temp = temp.next;
                i++;
            }

            // Delete node
            temp.next = temp.next.next;

            return head;
        }
    }

    // Print linked list
    static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Input: [1,2,3,4,5], n = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        System.out.println("Original List:");
        printList(head);

        Solution sol = new Solution();
        head = sol.removeNthFromEnd(head, n);

        System.out.println("After removing " + n + "th node from end:");
        printList(head);
    }
}