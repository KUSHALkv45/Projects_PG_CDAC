public class bub {
    static void sort(int [] array)
    {
        boolean swapped = false;
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array.length - i -1 ;j++)     
            // upto array.length - i - 1 because there wont be any element to compare with at the end
            
            {
              if(array[j] > array[j+1])
              {
                int temp = array[j+1];
                array[j+1] = array[j];
                array[j] = temp;
                swapped = true;
              }
            }
            if(!swapped)
            {
                break; // all elements are sorted
            }
        }
    }
    public static void main(String[] args) {
        int [] arr = {5,3,8,2,1};
        sort(arr) ;
        for(int i =0;i<5;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
