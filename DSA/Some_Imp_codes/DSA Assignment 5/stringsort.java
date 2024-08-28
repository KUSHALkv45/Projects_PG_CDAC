/*
7. Sorting Strings using Bubble Sort
9. Bubble Sort for Linked List by Swapping nodes *(we can store all the elements in array and sort them and then make a new linked list)
10.Bubble Sort On Doubly Linked List              Not recomended * we can do normal sorting

*/


public class stringsort {
   static boolean func(String A , String B)
    {
       if(A.compareTo(B) < 0)
       {
        return false;
       }
       else
       {
        return true;
       }
    }
   static void sort(String [] array)
    {
        boolean swapped_atleastonce = false;
      int l = array.length;
      for(int i = l-1;i>0;i--)
      {
        for(int j = 0;j< i;j++)
        {
            if(func(array[j],array[j+1] ))
            {
                
                swapped_atleastonce = true;
                String temp = array[j+1] ;
                array[j+1] = array[j] ;
                array[j] = temp;
            }
            else
            {
                continue;
            }
        }
        if(swapped_atleastonce )
        {
            continue;
        }
        else
        {
            break;
        }
      }
    }
    public static void main(String[] args) {
        String [] S = { "ABCD" , "CDE" , "EXSSS" , "ADS" , "END"};
        sort(S);
        for(int i= 0; i<5;i++)
        {
            System.out.println(S[i]);
        }
    }
   
    
}
