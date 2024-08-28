/* 

1. Print 1 to n without using loops
2. Sum of natural numbers using recursion
3. Mean of Array using Recursion
3. Sum of array elements using recursion
4. ***Decimal to binary number using recursion***
5. Sum of digit of a number using recursion
6. Print reverse of a string using recursion
7. Program for length of a string using recursion
8. Tail recursion to calculate sum of array elements.
9. Recursive function to check if a string is palindrome
10. Print Fibonacci Series in reverse order using Recursion
  
 
 */


public class second 
{
   
    static void recur(int start , int end)
    {
         if(start == end)
         {
            System.out.println(start);
            return;
            
         }
         else
         {
            System.out.println(start);
            recur(start+1, end);
         }
    }
    public static void main(String[] args) {
        recur(1, 10);
    }

    
}
