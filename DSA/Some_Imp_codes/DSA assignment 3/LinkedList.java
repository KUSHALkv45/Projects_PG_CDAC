import java.util.HashMap;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Scanner s = new Scanner(System.in);
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
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev; // Update the head to point to the new first node (prev)
    }
    public static LinkedList merge(LinkedList l1, LinkedList l2) {
        // Check if either l1 or l2 is null or empty
        if (l1 == null || l1.head == null) {
            return l2; // Return l2 if l1 is null or empty
        }
        if (l2 == null || l2.head == null) {
            return l1; // Return l1 if l2 is null or empty
        }
    
        Node temp1 = l1.head;
        Node temp2 = l2.head;
        LinkedList mergedList = new LinkedList();
        Node dummy = new Node(-1);
        Node current = dummy;
    
        // Merge the lists while both temp1 and temp2 are not null
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                current.next = temp1;
                temp1 = temp1.next;
            } else {
                current.next = temp2;
                temp2 = temp2.next;
            }
            current = current.next; // Move current pointer to the last added node
        }
    
        // Append remaining nodes from temp1 or temp2 if any
        if (temp1 != null) {
            current.next = temp1;
        }
        if (temp2 != null) {
            current.next = temp2;
        }
    
        // Set the head of the merged list to the next node of dummy (skip the dummy node)
        mergedList.head = dummy.next;
    
        return mergedList;
    }
    
    static void middle(LinkedList X)
    {
      if(X == null || X.head == null )
      {
        return;
      }
      if(X.head.next == null)
      {
        return;
      }
        Node slow = X.head;
        Node fast = X.head;
        while(fast != null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }
     // *********************** FLOYD's LOOP DETECTION TECHINIQUE: *********************
     public boolean hasLoop() {
    if (head == null || head.next == null) {
        return false; // No loop if list is empty or has only one node
    }

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next; // Move slow pointer one step
        fast = fast.next.next; // Move fast pointer two steps

        // Check if slow and fast pointers meet (indicating a cycle)
        if (slow == fast) {
            System.out.println(slow.data);                     // LOOP STARTING LINK can be modified to next also
            return true;          // Cycle detected
        }
    }

    return false;         // No cycle found
}

    
    /*      MY METHOD for LOOP CATCHING

    boolean hasloop()
    {
        Node temp = this.head;
        HashMap<Node,Integer>  helperhash = new HashMap<>();
        while(temp!=null)
        {
            if(helperhash.containsKey(temp))
            {
                
                return true;
            }
            else
            {
                helperhash.put(temp,1);
            }
            temp = temp.next;
        }
        return false;

    } 

    */
    public void find()
    {
        System.out.println("enter the value of N to find value from end");
          int N = s.nextInt();
          Node temp = this.head;
          int count = 0;
          while(temp != null)
          {
            count++;
            temp = temp.next;
          }
          if(N>count)
          {
            System.out.println("out of Limit");
            
          }
         
          else
          {
            temp = head;
            int req = count - N;
            while(req != 0)
            {
               temp = temp.next;
               req--;
            }
            System.out.println(temp.data);
          }

    }
    boolean Palindrome()
    { Node temp = this.head;
        int counter = 0;
        while(temp!=null)
        {
            counter++;
            temp = temp.next;
        }
        int [] helper = new int[counter];
        int i = 0;
        temp = head;
        while(temp!=null)
        {
            helper[i++] = temp.data;
            temp = temp.next;
        }
        for(int j=0;j<counter/2;j++)
        {
            if(helper[j] != helper[counter-j-1])
            {
                return false;
            }
        }
        return true;
    }
    static LinkedList add(LinkedList l1, LinkedList l2)
    {
        LinkedList required = new LinkedList();
        int n1 = 0;
        int n2 = 0;
        Node temp1 = l1.head;
        Node temp2 = l2.head;
        while(temp1 !=null)
        {
            n1++;
            temp1 = temp1.next;
        }
        while(temp2 !=null)
        {
            n2++;
            temp2 = temp2.next;
        }
        temp1 = l1.head;
        temp2 = l2.head;
        int [] A = new int [n1];
        int [] B = new int [n2];
        int [] help = new int [Math.max(n1,n2) + 1];
        int i=0,j = 0;
        while(temp1 !=null)
        {
             A[i++] =temp1.data;
             temp1 = temp1.next;
        }
        while(temp2 !=null)
        {
             B[j++] =temp2.data;
             temp2 = temp2.next;
        }
        if(n1>n2)
        { 
            int answer = 0;
            int carry = 0;
            int k = 0;
           while( k != n2)
           {
              help[k] = A[n1-1-k] + B[n2-k-1] + carry;
              carry = help[k]/10;
              help[k] = help[k] % 10;
              k++;
            }
            
            while( k != n1)
            {
                help[k] =  B[k] + carry;
              carry = help[k]/10;
              help[k] = help[k] % 10;
              k++;
            }
            help[n1] = carry;
            for(int m=0;m<=n1;m++)
            {

                answer += ((int) Math.pow(10,n1-m) ) * help[n1-m];
                required.insert_end(help[n1-m]);
                
            }
           System.out.println(answer);
        }
        else if(n2 > n1)
        {
            int answer = 0;
            int carry = 0;
            int k = 0;
           while( k != n1)
           {
              help[k] = A[n1-1-k] + B[n2-k-1] + carry;
              carry = help[k]/10;
              help[k] = help[k] % 10;
              k++;
            }
            
            while( k != n2)
            {
                help[k] =  B[k] + carry;
              carry = help[k]/10;
              help[k] = help[k] % 10;
              k++;
            }
            help[n2] = carry;
            for(int m=0;m<=n1;m++)
            {

                answer += ((int) Math.pow(10,n2-m) ) * help[n2-m];
                required.insert_end(help[n2-m]);
                
            }
           System.out.println(answer);
        }
        else
        {
            int answer = 0;
            int carry = 0;
            int k = 0;
           while( k != n2)
           {
              help[k] = A[n1-1-k] + B[n2-k-1] + carry;
              carry = help[k]/10;
              help[k] = help[k] % 10;
              k++;
            }
            
           
            help[k] = carry;
            for(int m=0;m<=k;m++)
            {

                answer += ((int) Math.pow(10,k-m) ) * help[k-m];
                required.insert_end(help[k-m]);
                
            }
           System.out.println(answer);
        }
        return required;
    }
    

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
       /*  myList.insert_end(30);
        myList.insert_beg(20);
        myList.insert_end(40);
        LinkedList List = new LinkedList();
        List.insert_beg(50);
        List.insert_beg(10);
        List.insert_end(60);

        myList.display();
         myList.delete(20);
        myList.display();
        myList.insert_end(10);
        myList.display();
        myList.delete(40);
        myList.display();  

       // myList.reverse();
       // myList.display();
       LinkedList mergedlist = merge(myList,List);
       mergedlist.display(); 
       middle(mergedlist); 
       
      myList.insert_beg(40);
      myList.insert_beg(30);
      myList.insert_beg(20);
      myList.insert_beg(10);
      Node insert = new Node(50);
      myList.head.next.next.next.next = insert;
     // insert.next = myList.head.next.next;
      if(myList.hasLoop( ))
      {
        System.out.println( " It has a loop");
      }
      else
      {
        System.out.println( " It does not has a loop in it");
      }
      myList.find();
     
      myList.insert_beg(10);
      myList.insert_beg(20);
      myList.insert_beg(20);
      myList.insert_beg(30);
     boolean b = myList.Palindrome();
     if(b)
     {
        System.out.println(" Yes it is a palindrome");
     }
     else
     {
        System.out.println("It is  not a palindrome");
     }


  */
  myList.insert_beg(1);
  myList.insert_beg(6);
  myList.insert_beg(8);
  myList.insert_beg(3);

  LinkedList List = new LinkedList();
  List.insert_beg(2);
  List.insert_beg(3);
  List.insert_beg(4);
  List.insert_beg(5);

  LinkedList addedlist =add(myList,List);
  addedlist.display();


        
       
  
    }
}