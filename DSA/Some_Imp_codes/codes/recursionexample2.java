public class recursionexample2
{
    static double rec(int a)
    {
        
          
       
       
        if(a==1)
        {
           return (double)1;
        }
        else
              {
                if(a%2==0)
                {
                    return ((double)-1/a + rec(a-1));
                }
                else
                {
                     return ((double)1/a + rec(a-1));
                 }
               }
     


    }
    public static void main(String [] args)
    {
       double answer = rec(4);
       
        System.out.println(answer);
    }
}