public class second_5 
{
   static int sum = 0;
    static void recur(int start )
    {
         if(start == 0)
         {
            
            System.out.println(sum);
            return;
            
         }
         else
         {
            sum += start%10;
            start = start/10;
            recur(start);
         }
    }
    public static void main(String[] args) {
        recur( 1029);
    }

    
}