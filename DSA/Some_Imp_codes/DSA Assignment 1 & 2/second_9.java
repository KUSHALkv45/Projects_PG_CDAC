public class second_9 {
    static int length = 0;
    static boolean check(String S)
    {
        if(length == S.length()/2 -1)
        {
            if(S.charAt(length) == S.charAt(S.length() - 1  - length))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(S.charAt(length) == S.charAt(S.length() -1 - length))
            {
                length++;
                return check(S);
            }
            else
            {
                return false;
            }
        }

    }
    public static void main(String[] args) {
        boolean b = check("ABCCBAb");
        if(b==true)
        {
            System.out.println(" IT is a PALINDROME");
        }
        else
        {
            System.out.println(" IT is not a PALINDROME");
        }
    }
    
}
