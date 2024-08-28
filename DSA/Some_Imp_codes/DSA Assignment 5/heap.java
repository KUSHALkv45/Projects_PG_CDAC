public class heap {
    static void  sort (int[] array)
    {
       // heapify all  the parent nodes
       int n = array.length;
       for( int i = n/2-1 ; i >= 0;i--)
       {
        heapify(array,n,i);                          
       }

       // extract all the lements to the required placing    // it is not necessary that the array is sorted only the max is largest.
       for(int i=n-1;i>0;i--)
       {
        int temp = array[0];     // root which is the largest and moving it to a end(i) (n-1) 
        array[0] = array[i] ;
        array[i] = temp;
        heapify(array,i,0) ;               
       }
    }
    static void heapify(int [] array , int size, int parentindex)
    {
        int leftsubparent = 2*parentindex + 1 ;
        int rightsubparent = 2*parentindex + 2 ;
        int newparent = parentindex;
        if(leftsubparent < size && array[leftsubparent] > array[parentindex])
        {
           newparent = leftsubparent ;
        }
        if(rightsubparent < size && array[rightsubparent] > array[parentindex])
        {
            newparent = rightsubparent;
        }
        if(newparent != parentindex)
        {
            int temp = array[parentindex] ;
            array[parentindex ] = array[newparent] ;
            array[newparent] = temp;

            heapify(array,size,newparent) ;
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
