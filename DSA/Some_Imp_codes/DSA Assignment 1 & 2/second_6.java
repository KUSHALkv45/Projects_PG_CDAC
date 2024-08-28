public class second_6 
{
   static StringBuilder sum  = new StringBuilder();
    static void recur(int start , String S)
    {
         if(start == 0)
         {
            sum.append(S.charAt(0));
            System.out.println(sum);
            return;
            
         }
         else
         {
           sum.append(S.charAt(start));
            recur(start-1, S);
         }
    }
    public static void main(String[] args) {
        recur(5, "ABCDEF");
    }

    
}