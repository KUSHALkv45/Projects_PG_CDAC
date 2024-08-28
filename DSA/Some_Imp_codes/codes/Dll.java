class Dnode
{
    int data;
    Dnode prev;
    Dnode next;
    Dnode(int data)
    {
      this.data = data;
      this.prev = null;
      this.next = null;

    }
}
public class Dll {
    Dnode head;
    Dll()
    {
        this.head = null;
    }
    Dll(int value)
    {
         head.data = value;

    }
   void insert_atbeg (int key)
    {
        Dnode newnode = new Dnode(key);
        if(head == null)
        {
            head = newnode;
        }
        else
        {
            head.next = newnode;
            newnode.prev = head;
        }
    }
   void insert_atend (int key)
    {
        Dnode newnode = new Dnode(key);
        if(head == null)
        {
            head = newnode;
        }
        else
        {
            Dnode temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.prev = temp;
        }
    }
    void display()
    {
        Dnode temp = head;
        if(temp == null)
        {
            System.out.println(" ur list is empty");
        }
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Dll mylist1 = new Dll();
        mylist1.display();
        mylist1.insert_atbeg(30);
        mylist1.insert_atbeg(20);
        mylist1.insert_atbeg(10);
        mylist1.insert_atend(40);
        mylist1.insert_atend(50);
        mylist1.display();



        
        
    }
    
}
