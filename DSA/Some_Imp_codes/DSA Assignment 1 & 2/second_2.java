public class second_2 
{
   static int sum = 0;
    static void recur(int start , int end)
    {
         if(start == end)
         {
            sum += start;
            System.out.println(sum);
            return;
            
         }
         else
         {
            sum += start;
            recur(start+1, end);
         }
    }
    public static void main(String[] args) {
        recur(1, 10);
    }

    
}
