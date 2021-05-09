package Easy.LinkedLists;
public class Solutions {

    public class ListNode {
        int val;
        ListNode next;

        ListNode (int x) { val = x;}
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode(-1), head = curr;
        ListNode node1 = l1, node2 = l2;

        while (node1 != null && node2 != null) {
            if (node1.val  > node2.val) {
                head.next = node2;
                node2 = node2.next;
            } else {
                head.next = node1;
                node1 = node1.next;
            }
            head = head.next;
        }

        if (node1 != null) {
            head.next = node1;
        }

        if (node2 != null) {
            head.next = node2;
        }

        return curr.next;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int length = 1;
        ListNode curr = head;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        int midpoint = length / 2;

        ListNode secondHalf = head;
        int counter = 1;
        while (secondHalf != null && counter <= midpoint) {
            secondHalf = secondHalf.next;
            counter++;
        }

        ListNode second = reverseList(secondHalf);

        ListNode compare = head;
        while (compare != null && second!= null) {
            if (!(compare.val == second.val)) {
                return false;
            }
            compare = compare.next;
            second = second.next;
        }

        return true;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}