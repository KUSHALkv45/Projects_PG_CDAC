package assigment_9;

import java.util.Scanner;

/*
  
  
  1. Write a Java program that throws an arithmetic exception and catch it using a try-catch block.

2. Write a Java program to create a method that takes an integer as a parameter and throws an exception if the number is odd.

3. Write a Java program throws an array index out of bound exception.

4. Write a code for arithmetic exception using one try block & multiple catch block & check which catch block handle that exception.
 
 

 */

public class ass1 {
	public static void main(String[] args) {
		int i;
		int j;
		int a = 1;
		Scanner s = new Scanner(System.in);
		System.out.println("enter the value of i");
		i = s.nextInt();
		
		try
		{
			j = s.nextInt();
			 a = i/j;
			
		}
		catch(ArithmeticException e)
		{
			System.out.println("ERROR OCURRED");
			
		}
		s.close();
		
			System.out.println(a);
		}
		
	}


