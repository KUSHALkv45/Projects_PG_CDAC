public class recursionexample
{
    static int  rec(int a)
    {
        int f_0 = 0;
        int f_1 = 1;
        if(a==0)
        {
            return f_0;
        }
        if (a==1)
        {
            return f_1;
        }
        else
        {
           return(rec(a-1) + rec(a-2));
          
           
        }
    }
    public static void main(String [] args)
    {
        int answer = rec(100);
       
        System.out.println(answer);
    }
}