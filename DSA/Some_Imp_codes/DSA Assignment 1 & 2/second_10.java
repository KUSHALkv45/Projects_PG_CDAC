public class second_10 {
    static int x = 0;
    static int fib (int n)
    {
        if(n==1)
        {
           
            return 0;
        }
        else if(n==2)
        {
            
            return 1;
        }
        else
        {
          return  ( fib(n-1) + fib(n-2) ) ;
            
           
        }
    }  
    public static void main(String[] args) {
        printreverse(10);
    }
    private static void printreverse(int i) {
        for(int j =i;j>0;j--)
        {
            System.out.println(fib(j));
        }
    }  
}
