public class heapsort {
    void sort(int [] array)
    {

        // constructing the heap

        int n = array.length;
        for(int i = n/2 -1;i>=0;i--)          // calling heapify on parent nodes; consider root = 0;
        {
            heapify(array,n,i);
        }
        

        // extracting the elements from array
        
        for(int i=n-1;i>0;i--)
        {
           int temp = array[0];
           array[0] = array[i];
           array[i] = temp;

           // heapify of resized heap(diminished heap)
           heapify(array,i,0);
           
        }

    }

    void heapify(int [] array,int n,int i)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < n && array[left] > array[largest])
        {
            largest = left;
        }
        if(right < n && array[right] > array[largest])
        {
            largest = right;
        }
        if(largest != i)
        {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array,n,largest);
        }
    }
        public static void main(String[] args) {
            int[] arr = {12, 11, 13, 5, 6, 7};
            heapsort sorter = new heapsort();
    
            System.out.println("Array before sorting:");
            printArray(arr);
    
            sorter.sort(arr);
    
            System.out.println("Array after sorting:");
            printArray(arr);
        }
    
       
        static void printArray(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

    
}
