public class binary {
    static void search(int target , int[] array)
    {
         s(target,array,0,array.length);
    }
    static void s(int target,int [] array,int left,int right)
    {
        boolean b = false;
        if(left <= right)
        {
            int mid = (left + right)/2;
            if(array[mid] < target)
            {
                s(target,array,mid+1,right);
            }
            else if(array[mid] == target)
            {
                System.out.println("Target found at index " + mid);
                b =true;
            }
            else
            {
                s(target, array, left, mid);
            }
        }
        if(!b)
        {
            System.out.println("Target not found ");
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int key = 5;
        search(key,array);
       
        
       
    }
    
}
