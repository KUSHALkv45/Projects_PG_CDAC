public class second_3 
{
   static int sum = 0;
    static void recur(int start , int [] array)
    {
         if(start == array.length-1)
         {
            sum += array[start];
            sum = sum/array.length ;
            System.out.println(sum);
            return;
            
         }
         else
         {
            sum += array[start];
            recur(start+1, array);
         }
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        recur(0, arr);
    }

    
}
