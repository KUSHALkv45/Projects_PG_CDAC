public class second_4 {

    static long answer =0;
    static int counter = 0;
    static void rec(int n)
    {
        if(n == 1)
        {
            answer += ( (int)(Math.pow(10,counter)));
            System.out.println(answer);
            return;
        }
        else if(n == 0)
        {
            System.out.println(answer);
            return;
        }
        else
        {
            if(n%2==1)
            {
                answer += ( (int)(Math.pow(10,counter)));
                counter++;
                n = n/2;
                rec(n);
            } 
            else
            {
                counter++;
                n = n/2;
                rec(n);

            }
        }
    }
    public static void main(String[] args) {
        rec(25);
    }
}
