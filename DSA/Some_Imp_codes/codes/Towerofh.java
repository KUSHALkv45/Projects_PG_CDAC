public class Towerofh {
    static void toh(int n,char a,char b,char c)
    {
       if(n>1)
       {
        toh(n-1,a,c,b);
        System.out.println("moving disks from " +a+ " rod  to "+ c);
        toh(n-1,b,a,c);
         
       }
       else
       {
        System.out.println("moving disks from " +a+ " rod  to "+ c);
        return;
       }
    }
    public static void main(String[] args) {
        toh(3,'A','B','C');
    }
    
}
