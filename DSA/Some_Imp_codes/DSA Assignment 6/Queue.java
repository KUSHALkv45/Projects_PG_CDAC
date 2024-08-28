public class Queue {
    private int maxSize;    // Maximum size of the queue
    private int[] queueArray; // Array to hold the queue elements
    private int front;      // Index of the front element
    private int rear;       // Index of the rear element
    private int currentSize; // Current number of elements in the queue

    // Constructor to initialize the queue
    public Queue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    // Enqueue operation to add an element to the rear of the queue
    public void enqueue(int value) {
        if (currentSize == maxSize) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        currentSize++;
        System.out.println(value + " enqueued to queue");
    }

    // Dequeue operation to remove the front element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return a default value (assuming -1 represents an empty queue)
        }
        int dequeuedValue = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        System.out.println(dequeuedValue + " dequeued from queue");
        return dequeuedValue;
    }

    // Peek operation to get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1; // Return a default value (assuming -1 represents an empty queue)
        }
        return queueArray[front];
    }

    // Utility function to check if the queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Main method to test the Queue implementation
    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // This will cause a queue full message

        System.out.println("Front element of queue: " + queue.peek());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("Front element of queue after dequeues: " + queue.peek());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // This will cause a queue empty message

        System.out.println("Front element of queue after more dequeues: " + queue.peek());
    }
}