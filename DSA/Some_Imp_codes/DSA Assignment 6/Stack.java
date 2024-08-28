// Stack class implementation using an array
public class Stack {
    private int maxSize;    // Maximum size of the stack
    private int[] stackArray; // Array to hold the stack elements
    private int top;        // Index of the top element in the stack

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;   // Stack is initially empty
    }

    // Push operation to add an element to the stack
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow: Cannot push element, stack is full");
        } else {
            stackArray[++top] = value;
            System.out.println(value + " pushed to stack");
        }
    }

    // Pop operation to remove the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop element, stack is empty");
            return -1; // Return a default value (assuming -1 represents an empty stack)
        } else {
            int value = stackArray[top--];
            System.out.println(value + " popped from stack");
            return value;
        }
    }

    // Peek operation to get the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Return a default value (assuming -1 represents an empty stack)
        } else {
            return stackArray[top];
        }
    }

    // Utility function to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Main method to test the Stack implementation
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); // This will cause a stack overflow

        System.out.println("Top element of stack: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Top element of stack after pops: " + stack.peek());

        stack.pop();
        stack.pop();
        stack.pop(); // This will cause a stack underflow

        System.out.println("Top element of stack after more pops: " + stack.peek());
    }
}
