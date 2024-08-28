
    class ListNode {
        int val;
        ListNode next;
    
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public class BubbleSortLinkedList {
    
        public static ListNode bubbleSort(ListNode head) {
            if (head == null || head.next == null) {
                return head; // Return if the list is empty or has only one node
            }
    
            boolean swapped; // To track if any swap is made in a pass
            ListNode temp; // Temporary node for swapping
            ListNode end = null; // Tracks the end of the unsorted portion
    
            do {
                swapped = false;
                ListNode current = head;
                ListNode prev = null;
    
                while (current != end && current.next != null) {
                    if (current.val > current.next.val) {
                        // Swap nodes
                        if (prev == null) {
                            // Update head if current is the head node
                            head = current.next;
                        } else {
                            prev.next = current.next;
                        }
                        temp = current.next.next;
                        current.next.next = current;
                        current.next = temp;
                        swapped = true;
                    }
                    // Move to the next pair of nodes
                    prev = (prev == null) ? head : prev.next;
                    current = prev.next;
                }
                // After each pass, the largest element gets bubbled to the end
                end = current;
            } while (swapped);
    
            return head;
        }
    
        // Helper method to print the linked list
        public static void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    
        public static void main(String[] args) {
            // Create a sample linked list
            ListNode head = new ListNode(5);
            head.next = new ListNode(3);
            head.next.next = new ListNode(8);
            head.next.next.next = new ListNode(1);
            head.next.next.next.next = new ListNode(6);
    
            System.out.println("Original List:");
            printList(head);
    
            // Sort the linked list using bubble sort
            head = bubbleSort(head);
    
            System.out.println("Sorted List:");
            printList(head);
        }
    }
    

    

