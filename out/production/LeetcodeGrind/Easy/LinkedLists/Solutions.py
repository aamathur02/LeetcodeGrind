class ListNode:
    def __init__(self, x) -> None:
        self.val = x;
        self.next = None
    


def delete_node(node: ListNode) -> None:
    node.val = node.next.val;
    node.next = node.next.next;