public class insertionsort {
   static void sort(int [] array)
   {
    int key = 0;
    
    for(int i =1;i<array.length;i++)          // comparision starting from 1 because if we start with 0 there is no comparisions
    {
        key = array[i];
        int j= i-1;                           // j = i-1 just the index before the key's index 
        while(j>=0 && array[j] > key)         // compare the elements eith key starting from butone element and move if they are bigger
        {
            array[j+1] = array[j];            // [1,2,4,3,5,6] consider here key = 3 so we compare staring from array[3] so move it to  
            j = j-1;                           // its right and decrease the j counter as we have to compare remaining elements too    
        }
        j = j+1;                               // correct index for inserting the key
     array[j] = key;  

    }
    for(int k =0;k<array.length;k++)
    {
        System.out.print(array[k] + " ");
    }
   }
    public static void main(String [] args)
    {
        
        int [] array = {1,2,4,3,5,6,8,7,10,9};
       sort(array) ;
    }
}

