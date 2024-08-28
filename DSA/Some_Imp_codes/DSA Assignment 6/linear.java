public class linear  {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int key = 5;
        boolean b = false;
        for(int i=0;i<9;i++)
        {
            if(arr[i] == key)
            {
                b =true;
                System.out.println("key found at" + i);
                break;

            }
        }
        if(!b)
        {
            System.out.println("key not found ");
        }
    }
    
}
