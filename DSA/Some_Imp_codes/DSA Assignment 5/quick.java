public class quick {
    static void swap(int [] array , int l , int r)             // swap function shortcut 
    {
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
    static void sort(int [] array)                         
    {
        int n = array.length;
        quicksort(array,0,n-1);
    }
    static void quicksort(int[] array,int low , int high)                        
    {
        if(low < high)
        {

        int pa = parition(array,low,high);
        quicksort(array, low, pa-1);                        // finding partition between low and pa-1 as pa is perfectly placed
        quicksort(array,pa + 1 , high);                     // other half

        }
    }
    static int parition(int [] array , int low , int high)
    {
       int pivot = array[high];
       int i = low-1;       // we will have to increment continuosly so we take it as low-1
       for(int j = low;j<=high-1 ;j++)                    // here we are finding a perfect spot for our pivot so that the elem at left
                                                          // smaller and at right elements are greater 
       {
        if(array[j] < pivot)      // if it is small change it with the last element in the array
        {
            i++;
            swap(array,i,j);
        }
        else
        {
            continue;
        }
       }
       swap(array,i+1 , high) ;          // lastly keep the pivot in its postion found
       return i+1;                        // i+ 1 is the position of the pivot return that position
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
