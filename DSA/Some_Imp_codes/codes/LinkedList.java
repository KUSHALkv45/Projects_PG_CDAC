class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    public void insert_beg(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insert_end(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void delete(int key) {
        Node temp = head;
        Node prev = null;

        // If the key is at the head node
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }

        // Iterate through the list to find the key
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key not present in the list
        if (temp == null) {
            System.out.println("Key not found");
            return;
        }

        // Unlink the node from the list
        prev.next = temp.next;
        System.out.println("Node with data " + key + " deleted");
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.insert_end(30);
        myList.insert_beg(20);
        myList.insert_end(40);
        myList.display();
        myList.delete(20);
        myList.display();
        myList.insert_end(10);
        myList.display();
        myList.delete(40);
        myList.display();
    }
}
