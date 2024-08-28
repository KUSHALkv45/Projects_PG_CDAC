public class balanced {
    public static String isBalanced(String s) {
        int n = s.length();
    char [] X = new char[n];
        int top = -1;
        for(int i=0;i<n;i++)
        {
            char x = s.charAt(i);
            switch(x)
            {
                  case '{' :
                    {
                         if(top == -1) 
                        {
                               X[++top] = x;
                     
                        } 
                       
                        else
                        {
                            X[++top] = x;
                        }
                        break;
                    }
                    case '(' :
                    {
                          if(top == -1) 
                        {
                               X[++top] = x;
                     
                        } 
                       
                        else
                        {
                            X[++top] = x;
                        }
                        break;
                    }
                     case '[' :
                    {
                          if(top == -1) 
                        {
                               X[++top] = x;
                     
                        } 
                       
                        else
                        {
                            X[++top] = x;
                        }
                        break;
                    }
                     case ')' :
                    {
                          if(top == -1) 
                        {
                               X[++top] = x;
                     
                        } 
                        else if(X[top] == '(')
                        {
                            top--;
                        }
                       
                        else
                        {
                            X[++top] = x;
                        }
                        break;
                    }
                     case '}' :
                    {
                          if(top == -1) 
                        {
                               X[++top] = x;
                     
                        } 
                        else if(X[top] == '{')
                        {
                            top--;
                        }
                       
                        else
                        {
                            X[++top] = x;
                        }
                        break;
                    }
                     case ']' :
                    {
                          if(top == -1) 
                        {
                               X[++top] = x;
                     
                        } 
                        else if(X[top] == '[')
                        {
                            top--;
                        }
                       
                        else
                        {
                            X[++top] = x;
                        }
                        break;
                    }
                 
            }
        }
        if(top == -1)
        {
            return "YES" ;
        }
        else
        {
            return "NO";
        }
        

    }
    public static void main(String[] args) {
        String S = "{}{}{{{{{}}}}}";
        String s = isBalanced(S);
        System.out.println(s);

    }

}



