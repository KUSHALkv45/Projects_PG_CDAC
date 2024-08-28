class Recursionexample3
{
    static int x = 1;
    static void rec(int a)
    {
        
        if(x == 10)
        {
            System.out.println(a+" X "+ x + " = " + a*x );
            
            
        }
        else
        {
            System.out.println(a+" X "+ x + " = " + a*x ); 
            x++;
            rec(a);
        }
    }
    public static void main(String[] args) {
        rec(8);
    }
}