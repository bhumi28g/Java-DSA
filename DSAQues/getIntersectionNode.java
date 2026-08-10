public class getIntersectionNode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode GetIntersectionNode(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode headA = l1;
        ListNode headB = l2;

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;

            if (headA == headB) {
                return headA;
            }

            if (headA == null) {
                headA = l2;
            }

            if (headB == null) {
                headB = l1;
            }
        }

        return headA;
    }

    public static void main(String[] args) {

        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = common;

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(1);
        l2.next.next.next = common;

        ListNode result = GetIntersectionNode(l1, l2);

        if (result != null) {
            System.out.println("Intersection Node: " + result.val);
        } else {
            System.out.println("No Intersection");
        }
    }
}