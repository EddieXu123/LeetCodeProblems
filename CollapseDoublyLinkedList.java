/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class CollapseDoublyLinkedList {
    public Node flatten(Node head) {
        // Idea: We only care about nodes with children
        Node original = head;
        while (original != null) { 
            // If the current node doesn't have a child, iterate
            if (original.child == null) {
                original = original.next;
                continue;
            }
            
            // If the current node has a child
            // We want to record the nodes child
            Node childNode = original.child;
            // Reach the end of that nodes row
            while (childNode.next != null) {
                childNode = childNode.next;
            }
            // The last node in that row should point to the row above it, one right of the original node that made us go down the path
            childNode.next = original.next;
            // We then set the that node's previous to the last node in the child row (if it's not null)
            if (original.next != null) {
                original.next.prev = childNode;
            }
            // Then, we collapse the child row
            // The next node in the top row is obviously the node's child
            original.next = original.child;
            // The previous of that child is the current node
            original.child.prev = original;
            // We collapse the child row because we already have the node ordering
            original.child = null;
        }
        
        return head;
    }
}
