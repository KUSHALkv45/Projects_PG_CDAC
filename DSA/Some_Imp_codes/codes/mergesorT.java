public class mergesorT {
    void mergesort( int[] array)
    {
        int [] temp = new int [array.length];
        divide(array,temp,0,array.length-1);
    }
    void divide(int [] array,int [] temp , int left , int right)
    {
        if(left<right)
        {
        int mid = left + (right - left)/2;
        divide(array,temp,left,mid);
        divide(array,temp,mid+1,right);
        conquer(array,temp,left,mid,right); 
        }
    }
    void conquer(int[] array,int [] temp, int left , int mid , int right)
    {
        for(int l =0;l<=right;l++)
        {
            temp[l] = array[l];
        }
        int i = left;
        int j = mid +1;
        int k = left;
        while(i <= mid && j <= right)
        {
            if(temp[i] <= temp[j])
            {
                array[k++] = temp[i++]; 
            }
            else
            {
                array[k++] = temp[j++];
            }
        }
        while( i <= mid)
        {
            array[k++] = temp[i++] ;
        }
        while( j <= right)
        {
            array[k++] = temp[j++] ;
        }
    }
    public static void main(String[] args) {
        mergesorT s = new mergesorT();
        int [] a = {1,3,2,5,4,9,7,6};
        s.mergesort(a);
        for(int i=0;i<8;i++)
        {
            System.out.print(a[i] + " ");
        }
    }
    
}
