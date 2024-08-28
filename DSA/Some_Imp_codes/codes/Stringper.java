public class Stringper {
    static void perm(String s,String a)
    {
        if(s.length()==0)
        {
            System.out.println(a);
        }
        else
        {
            for(int i = 0;i<s.length();i++)
            {
                char h1 = s.charAt(i);
                String remaining = s.substring(0,i) + s.substring(i+1);
                perm(remaining,a+h1);

            }
        }
    }
    public static void main(String[] args) {
        perm("123"," ");
    }
    
}
