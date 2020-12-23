# Explantions for Leetcode Easy LinkedList Set

## Delete Node

### Java and Python:
1. set the value of the current node as the value of the next node
2. set the next pointer of the current node as node.next.next

## Remove Nth Node from End of List

### Java
1. Create two new ListNode pointer (first and second) and their next is the head Node
2. Create a for loop and advance the first pointer so that the gap between the first and second pointer is n nodes (same as input n)
3. Use while loop to iterate through the Linked List and the clause should be while first != null
4. Do second.next = second.next.next and return dummy.head to return the head

## Reverse Linked List

### Java O(1) space and O(n) time
1. create two pointer, curr and prev
    * set prev to null and curr to head
2. Use while loop with condition (curr != null)
3. Create a new pointer named nextTemp with reference to curr.next
4. set curr.next to prev, set prev = curr, and set curr to nextTemp
5. return prev

## Merge two sorted lista

### Java
1. create a new ListNode w value (-1) and name it head
2. create another ListNode curr and set it equal to head
3. Create two more ListNode for l1 and l2
4. Create a while loop 
5. If node1 is bigger, set head.next to node2 and advance node2
6. Else, do the same but for node1
7. Advance head
8. If node1 or node2 are not null, add those to the end
9. return curr.next, which is reference to beginning of linkedlist

## Palinrome Linked List

## Java
1. head is null ==> return true
2. find length of linked list, start length at 1 because head exists
3. midpoint formula is just length /2 (//2 for python)
4. while to get midpoint ListNode is counter <= midpoint, and initialize counter to 1
5. set another ListNode to return node of reverse List
6. one more ListNode set to head
7. clause for while compare is both front and mid pointer != null

## Linked List Cycle
1. idea is that you have fast pointer and slow pointe
2. If there is no cycle, then fast pointer will reach end and we return false
3. If there is a cycle, at some point the fast pointer will reach slow pointer and we can return true
4. while loop clause should be slow != null
    * intialize slow to head and fast to head.next
    * inside while, check for fast = null or fast.next == null ==> if true, return false meaning we reached end of list and no cycle
5. Inside while, set slow = slow.next and fast = fast.next.next