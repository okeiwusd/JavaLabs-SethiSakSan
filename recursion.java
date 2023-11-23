public class recursion {
    public static void main(String[] args) {
        // Create the linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Print the original list
        System.out.println("Original List:");
        printList(head);

        // Reverse the list using recursive function
        head = reverseList(head);

        // Print the reversed list
        System.out.println("Reversed List:");
        printList(head);
    }

    public static Node reverseList(Node head) {
        // Base case: an empty list or a list with a single node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list after the current node
        Node reversedList = reverseList(head.next);

        // Update the next node's reference to point back to the current node
        head.next.next = head;

        // Set the current node's next reference to null
        head.next = null;

        // Return the reversed list
        return reversedList;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}