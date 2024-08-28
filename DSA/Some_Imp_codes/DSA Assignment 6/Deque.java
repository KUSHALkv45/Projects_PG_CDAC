// Node class to represent a node in the doubly linked list
class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

// Deque (Double-Ended Queue) class implementation using a doubly linked list
public class Deque {
    private Node front;
    private Node rear;
    private int size;

    // Constructor to initialize the Deque
    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }

    // Method to check if the Deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the Deque
    public int size() {
        return size;
    }

    // Method to add an element to the front of the Deque
    public void addFront(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
        System.out.println(data + " added to the front of the Deque");
    }

    // Method to add an element to the rear of the Deque
    public void addRear(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
        System.out.println(data + " added to the rear of the Deque");
    }

    // Method to remove an element from the front of the Deque
    public int removeFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove from front.");
            return -1; // Return a default value (assuming -1 represents an empty Deque)
        }
        int removedData = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        System.out.println(removedData + " removed from the front of the Deque");
        return removedData;
    }

    // Method to remove an element from the rear of the Deque
    public int removeRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove from rear.");
            return -1; // Return a default value (assuming -1 represents an empty Deque)
        }
        int removedData = rear.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        size--;
        System.out.println(removedData + " removed from the rear of the Deque");
        return removedData;
    }

    // Method to get the front element of the Deque without removing it
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1; // Return a default value (assuming -1 represents an empty Deque)
        }
        return front.data;
    }

    // Method to get the rear element of the Deque without removing it
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1; // Return a default value (assuming -1 represents an empty Deque)
        }
        return rear.data;
    }

    // Main method to test the Deque implementation
    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.addFront(10);
        deque.addFront(20);
        deque.addRear(30);
        deque.addRear(40);

        System.out.println("Front element: " + deque.getFront());
        System.out.println("Rear element: " + deque.getRear());

        deque.removeFront();
        deque.removeRear();

        System.out.println("Front element after removal: " + deque.getFront());
        System.out.println("Rear element after removal: " + deque.getRear());
    }
}
