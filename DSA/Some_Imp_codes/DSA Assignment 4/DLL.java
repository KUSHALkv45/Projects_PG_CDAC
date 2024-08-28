/*

1.Doubly Linked List Insertion in java
2.Reverse a Doubly Linked List in java
3.Delete a node in a Doubly Linked List in java
4.Program to find length of Doubly Linked List in java
5.Find the largest node in Doubly linked list in java
6.Insert value in sorted way in a sorted doubly linked list in java
 
*/

class node
{
    int data;
    node prev;
    node next;
    node()
    {
        next = null;
        prev = null;
    }
    node(int data)
    {
        this.data = data;
        next = null;
        prev =null;
    }
} 
public class DLL
{
    node head;
    DLL()
    {
        this.head = null;

    }
    DLL(int data)
    {
        this.head.data = data;
    }
    public void insert(int key)
    {
        node newnode = new node(key);
        if(head == null)
        {
            this.head = newnode ;
        }
        else
        {
            node temp = head;
            while(temp.next != null)
            {
                temp = temp.next;

            }
            temp.next = newnode;
            newnode.prev = temp;
        }
    }
    public void display()
    {
        node temp = this.head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public DLL reverse()
    {
        node temp = this.head;
        node pre = null;
        node nex = null;
        while(temp != null)
        {
            nex = temp.next;
            temp.next = pre;
            temp.prev = nex;
            pre = temp;
            temp = nex;

        }
        this.head = pre;
        return this;
        
    }
    public void delete(int target)
    {
        node temp = this.head;
        if(temp.data == target)
        {
            this.head = temp.next;
            return;
        }
        else
        {
            while(temp != null && temp.data != target)
            {
                temp = temp.next;
            }
            if(temp == null)
            {
                System.out.println(" This list does not have that value");
                return;
            }
            else
            {
               node t = temp.next;
               node p =temp.prev;
               if(t==null)
               {
                p.next = null;
               }
               else
               {
                p.next = t;
                t.prev = p;
               }
            }
        }
    }
    public static void main(String[] args) {
        DLL l1 = new DLL();
    l1.insert(10);
    l1.insert(20);
    l1.insert(30);
    l1.insert(40);
    System.out.println("Original List:");
    l1.display();

    l1 = l1.reverse();
    System.out.println("Reversed List:");
    l1.display();

    l1.delete(20);
    System.out.println("List after deleting 20:");
    l1.display();


    System.out.println("Length of the List :");
    l1.length();


    System.out.println("Largest value in the list:");
    l1.largest();

    l1.sortedinsert(50);
    System.out.println("Sorted insert of 50 :");
    l1.display();

    }
    private void sortedinsert(int i) 
    {   
        
        node newnode = new node(i);
        if(this.head == null)
        {
         this.head = newnode;
         return;
        }
       node temp = this.head;
       node p = null;
       while(temp !=null && temp.data < i )
       {
           p = temp;
           temp = temp.next;
       }
       if (p == null)
        {
        // Insert at the beginning (newnode becomes new head)
        newnode.next = this.head;
        this.head.prev = newnode;
        this.head = newnode;
        } 
    else if (temp == null) {
        // Insert at the end (after the last node)
        p.next = newnode;
        newnode.prev = p;
    } else 
    {
        // Insert in between nodes
        p.next = newnode;
        newnode.prev = p;
        newnode.next = temp;
        temp.prev = newnode;
    }

}
         
    
    private  void largest() 
    {
        node temp = this.head;
        int co = 0;
        while(temp != null)
        {
            if(temp.data > co)
            {
                co = temp.data ;
            }
            temp = temp.next;
        }
        System.out.println(co);
    }
    private void length() 
    {
        node temp = this.head;
        int co = 0;
        while(temp != null)
        {
            co++;
            temp = temp.next;
        }
        System.out.println(co);
    }
}