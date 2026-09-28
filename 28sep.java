import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Insert at Front
    void insertAtFront(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    // Insert at End
    void insertAtEnd(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = temp;
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = temp;
    }

    // Delete from Front
    void deleteAtFront() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        head = head.next;
    }

    // Delete from End
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        // Only one node
        if (head.next == null) {
            head = null;
            return;
        }

        Node curr = head;

        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;
    }

    // Display
    void display() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Enter element for front: ");
        int front = sc.nextInt();

        list.insertAtFront(front);

        System.out.print("Enter element for end: ");
        int end = sc.nextInt();

        list.insertAtEnd(end);

        System.out.println("Linked List:");
        list.display();

        // Delete from Front
        list.deleteAtFront();

        System.out.println("\nAfter deleting from front:");
        list.display();

        // Delete from End
        list.deleteAtEnd();

        System.out.println("\nAfter deleting from end:");
        list.display();
    }
}