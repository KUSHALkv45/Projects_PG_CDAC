public class sele {
    static void sort(int [] array)
    {
        
        for(int i=0;i<array.length-1;i++)
        {
            int min = i;
            // min element currently at i 
            for(int j=i+1;j<array.length ;j++)     
           
            
            {
              if(array[j] < array[min])
              {
                min = j;
                
              }                                         
             
            }
            int temp = array[i];        // swap the in element with element at index i
            array[i] = array[min];
            array[min] = temp;

           
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
    

