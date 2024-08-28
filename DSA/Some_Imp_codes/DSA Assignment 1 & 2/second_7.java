
public class second_7 
{
    
   
    static int recur(String s)
    {
         if(s.isEmpty())
         {
           
            return 0;
            
         }
         else
         {
            
           return 1 + recur(s.substring(1));
         }
    }
    public static void main(String[] args) {
       int answer = recur("ABCDE");
       System.out.println(answer);
    }

    
}
