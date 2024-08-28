public class inser {
    static void sort(int [] array)
    {
        
        for(int i=1;i<array.length;i++)
        {
            int key = array[i] ;
           
            for(int j=0;j<i ;j++)     
           
            
            {
              if(array[j] > key)
              {
               
                for(int k=i;k>j;k--)
                {
                    array[k] = array[k-1];
                }
                array[j] = key;
                break;
                
              }  
              else
              {
                continue;
              }                                       
             
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
    

