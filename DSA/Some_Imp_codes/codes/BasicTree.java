import java.util.Scanner;

class Tree {
    int data;                          // or weight
    Tree left;
    Tree right;
   
    Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BasicTree {
    private Scanner s = new Scanner(System.in);
    private Tree root;

    public BasicTree() {
        this.root = null;
    }

    public void insert(int data) {
        this.root = insertRecursive(this.root, data);
    }

    private Tree insertRecursive(Tree root, int data) {
        if (root == null) {
            return new Tree(data);
        }

        if (data <= root.data) {
            root.left = insertRecursive(root.left, data);
        } else {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    public void display()
    {
        if (this.root == null) 
        {
            System.out.println("Tree is empty");
        }
       else
       {

       
       System.out.println("1. Inorder");
       System.out.println("2. preorder");
       System.out.println("3. postorder");
       int choice = s.nextInt();
      switch(choice)
       {
        case 1:
        {
          Inorder(root);
          break;
        }
        case 2:
        {
          Preorder(root);
          break;
        }
        case 3:
        {
          Postorder(root);
          break;
        }
        default:
        {
            System.out.println(" Wrong value");
            break;
        }
       
           
            
        }
       

        
       }
    }

    void Inorder(Tree root) {
        if (root != null) {
            Inorder(root.left);
            System.out.print(root.data + " ");
            Inorder(root.right);
        }
       
    }
     void Preorder(Tree root) {
        if (root != null) {
            System.out.print(root.data + " ");
            Preorder(root.left);
            
            Preorder(root.right);
        }
        
    }
     void Postorder(Tree root) {
        if (root != null) {
            Postorder(root.left);
            
            Postorder(root.right);
            System.out.print(root.data + " ");
        }
        
    }
    int func(Tree root) {
        if (root == null) {
            return -1;  // Base case: If the node is null, the height is 0.
        } else {
            // Recursively calculate the height of the left and right subtrees
            int l = func(root.left);   // Height of the left subtree
            int r = func(root.right); // Height of the right subtree
            
            // Compare heights of left and right subtrees to determine the maximum depth
           return ( Math.max(l,r) + 1 );
        }
    }
    
   void depth( )
    {
        System.out.println(func(this.root)) ;
    }
   void delete(int key)
   {
     root = delete(root,key);         // deleting the key and updating the root and returning the updated root
   }
   Tree delete(Tree root,int key)
{
    // search for that key
   if(root == null)  // cr case
   {
    return null;
   }
   // traversing

   if(root.data > key)
   {
    root.left = delete(root.left,key);
   }
   else if(root.data < key)
   {
    root.right = delete(root.right, key);
   }
   else
   {
    // we found the key in the tree
    // case 1 and case 2: with 0 and 1 child
    if(root.left == null)
    {
        return root.right;                     // root is changed to root.right; // when it is at starting itself 
                                               //   ********or it goes to root.right or .left *******
    }
    else if(root.right == null)
    {
        return root.left;
    }

    // case 3: main case here we traverse the tree and find the least value in right subtree and change it to the root node 
    // not a really important point(INORDER) but we can change according to our way how we have to change the root
    else
    {
       Tree succesor = findmin(root.right);  
       // as the least element in the right subtree will always be greater than its left subtree   // INORDER   
       root.data = succesor.data;
      root.right = delete(root.right,succesor.data);
    }
   }
   return root;              // returning root *** just before completing the method ****
}
   Tree findmin(Tree node)
   {
     while(node.left !=null)
     {
        node = node.left;
     } 
     return node;
   }

   

  

    public static void main(String[] args) {
        BasicTree tree = new BasicTree();

       
       // tree.display();

        tree.insert(5);
        tree.insert(11);
        tree.insert(17);
        tree.insert(15);
        tree.insert(12);
        tree.insert(20);
        tree.insert(25);
        tree.insert(13);

        
       // tree.display();
        //System.out.println();
        tree.depth();
       // tree.delete(17);
       // tree.display();
        
    }
}
/* 
 if (root == null) {
            return null; // Key not found
        }

        // Traverse to find the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete found

            // Case 1 & 2: Node with 0 or 1 child
            if (root.left == null) {
                return root.right; // Replace with right child or null
            } else if (root.right == null) {
                return root.left; // Replace with left child
            }

            // Case 3: Node with 2 children
            TreeNode successor = findMin(root.right); // Find in-order successor
            root.val = successor.val; // Replace value with successor
            root.right = deleteNode(root.right, successor.val); // Delete successor
        }

        return root;
    }

    // Helper method to find the minimum node (in-order successor)
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }


 */