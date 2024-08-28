

class Tree
{
    int data;
    Tree left;
    Tree right;
    Tree()
    {
        left = null;
        right = null;
    }
    Tree(int data)
    {
        this.data = data;
        left = null;
        right =null;
    }
} 

public class bt {
    Tree root;
    bt()
    {
        root = null;
    }
    bt(int data )
    {
        this.root.data = data;
        this.root.left = null;
        this.root.right = null;
    }
    public void insert(int key)
    {
       root =  ins(root,key);
    }

    /* 
     
    public void insert(int key)
    {
       root =  ins(root,key,true);
    }
    public Tree ins(Tree root,int key,boolean x)
    {
        if(root == null)
        {
            return new Tree(key);
        }
        if(x)
        {
            root.left = ins(root.left,key,false);
        }
        else  //(root.right == null)
        {
            root.right = ins(root.right,key,true);
        }
        //else
        //{
         //   root.left = ins(root.left,key); 
       // }
        return root;
    } 
    
    */
    public Tree ins(Tree root,int key)
    {
        if(root == null)
        {
            return new Tree(key);
        }
        if(root.left == null)
        {
            root.left = ins(root.left,key);
        }
        else if(root.right == null)
        {
            root.right = ins(root.right,key);
        }
        else
        {
           root.left = ins(root.left,key); 
        }
        return root;
    }
    void In()
    {
        Inorder(this.root);
    }
    void pre()
    {
        Preorder(this.root);
    }
    void post()
    {
        Postorder(this.root);
    }
    public void Inorder(Tree root)
    {
        
        if(root != null)
        {
          Inorder(root.left);
          System.out.print(root.data + " ");
          Inorder(root.right);
        }

    }
    public void Preorder(Tree root)
    {
        if(root != null)
        {
            System.out.print(root.data + " ");
            Preorder(root.left);
            Preorder(root.right);
        }
    }
    public void Postorder(Tree root)
    {
        if(root != null)                                            
        {
            Postorder(root.left);
            Postorder(root.right);
            System.out.print(root.data + " ");
        }
    } 
         
                                                                       /*

                                                                        7.Write tree traversals in java
                                                                           8.Search a node in Binary Tree
                                                                        9.In order Successor of a node in Binary Tree
                                                                              10.Print Head node of every node in Binary Tree
        
                                                                      */
   void search(int key)
   {
     sea(root,key,null);
   }
   
   void sea (Tree root, int key, Tree parent)
   {
    if(root == null)
    {
        return ;
    }
        
    if(root.data == key)
      {
        if(parent != null)
        System.out.println("the parent node of ur node with data is " + parent.data);
        return;
       }
    
         
        sea(root.left,key,root) ;
        sea(root.right,key,root) ;
    }
   
  public static void main(String[] args) {
    bt t = new bt();
    t.insert(1);
    t.insert(2);
    t.insert(3);
    t.insert(4);
    t.insert(5);
    t.insert(6);
   
    t.search(6);
    t.display();
  }
private void display()
 {
    if(root == null)
    {
        System.out.println(" this is a empty tree");
    }
    else
    {
        di(this.root,null);
    }
    
    

 }
 void di(Tree root,Tree parent)
 {
    if( root == null)
    {
        return ;
    }
    if(parent == null)
    {
        System.out.println(" This is Parent root of the tree");
    }
    else
    {
        System.out.println("leaf node is : " + root.data + " head of the root is " + parent.data);
    }
    di(root.left,root);
    di(root.right,root);
 }
 

}
    

    

