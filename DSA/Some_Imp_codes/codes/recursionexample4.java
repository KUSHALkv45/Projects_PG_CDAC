public class recursionexample4 {
    static int gcd (int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        else
        {
            int temp = a%b;
           return gcd(b,temp);
        }
        
    }
    public static void main(String[] args) {
        int answer = gcd(15,10);
        System.out.println(answer);
    }
    
}
