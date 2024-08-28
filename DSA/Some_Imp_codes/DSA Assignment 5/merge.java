public class merge {
     static void sort(int[] array)
     {
        int l = array.length;
        Divide(array,0,l-1);
     }
     static void Divide(int[] array , int left , int right)
     {
       if(left < right) 
       {
        int mid = left + (right - left) / 2;        
        Divide(array,left,mid);
        Divide(array,mid+1,right);
        
        conquer(array,left,mid,right);
       }
     }
     static void conquer(int [] array , int left , int mid , int right )
     {
        int n1 = mid - left + 1;
        int n2 = right - mid ;
        int [] lefta = new int[n1];
        int [] righta = new int[n2];
         for(int i = 0 ; i<n1;i++)
        {
            lefta[i] = array[left + i];
        }
        for( int j = 0;j<n2;j++)
        {
            righta[j] = array[mid + 1 + j];
        }
        int k = left;
        int l = 0;
        int m = 0;
        while(l< n1 && m < n2)
        {
          if(lefta[l] <= righta[m])
          {
            array[k++] = lefta[l++] ;
          }
          else
          {
            array[k++] = righta[m++] ;
          }
        }
       while(l<n1)
        {
            array[k++] = lefta[l++] ;
        }
        while(m<n2)
        {
            array[k++] = righta[m++] ;
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
