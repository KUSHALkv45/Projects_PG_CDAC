package assign8.com;

import java.util.Arrays;
import java.util.Scanner;

public class Arrayoperation {
	public static Scanner s = new Scanner(System.in);
    public static void Showarray(int [] a)
		{
	       for(int i=0;i<a.length;i++)
	       {
	    	   System.out.println(a[i]);
	       }
			
		}
public static void sum(int [] a)
{
	int sum = 0;
	for(int i=0;i<a.length;i++)
    {
 	   sum = sum + a[i];
    }
	System.out.println(sum);
}
public static void average(int [] a)
{
	double sum = 0;
	for(int i=0;i<a.length;i++)
    {
 	   sum = sum + a[i];
    }
	sum = sum/a.length;
	System.out.println(sum);
}
public static void largest(int [] a)
{
	int sum = Integer.MIN_VALUE;
	for(int i=0;i<a.length;i++)
    {
 	  if(a[i]>sum)
 	  {
 		  sum = a[i];
 	  }
    }
	
	System.out.println(sum);
}
public static void smallest(int [] a)
{
	int sum = Integer.MAX_VALUE;
	for(int i=0;i<a.length;i++)
    {
 	  if(a[i]<sum)
 	  {
 		  sum = a[i];
 	  }
    }
	
	System.out.println(sum);
}
public static void sort(int [] a)
{
	Arrays.sort(a);
	System.out.println(Arrays.toString(a));
}

public static void main(String[] args) {
	System.out.println("Enter the length of the Array");
    int n = s.nextInt();

		int [] temp = new int[n];
		System.out.println("Enter no for Array");
		for(int i =0;i<n;i++)
		{
			temp[i] = s.nextInt();
		}
		int choice;
		do 
		{
			System.out.println("1. showarray");
			System.out.println("2. sum");
			System.out.println("3. average");
			System.out.println("4. largest");
			System.out.println("5. smallest");
			System.out.println("6. Sort");
			System.out.println("7. EXIT");
			System.out.println("enter ur choice");
			
			choice = s.nextInt();
			switch(choice)
			{
			case 1:
			{
				Showarray(temp);
				break;
			}
			case 2:
			{
				sum(temp);
				break;
			}
			case 3:
			{
				average(temp);
				
				break;
			}
			case 4:
			{
				
				largest(temp);
				break;
			}
			case 5:
			{
				smallest(temp);
				break;
			}
			case 6:
			{
				sort(temp);
				break;
			}
			case 7:
			{
				System.out.println("bye bruh");
				break;
			}
			default :
			{
				System.out.println("WRONG input  bruh");
				break;
			}
			
			}
		}while(choice!=7);
}

}
