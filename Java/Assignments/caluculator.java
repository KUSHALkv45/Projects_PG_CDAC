package assignment.in;

import java.util.Scanner;

public class caluculator {
	public static int lcm(int a, int b)
	{
		int lcm;
		
		int g = gcd(a,b);
		
		lcm = (a*b)/g;
		return lcm;
	}
	public static int gcd(int a,int b)
	{
		while(b!=0)
		{
			 int temp = a%b;
			a = b;
			b = temp;
			
			
		}
		return a;
	}
	public static void addition(int n1,int d1,int n2,int d2)
	{
		
		
		int newd = lcm(d1,d2);
		int newn = n1*(newd/d1) + n2*(newd/d2) ;
		int temgcd = gcd(newn,newd);
		newd = newd/temgcd;
		newn = newn/temgcd;
		System.out.println("ur fraction is");
		System.out.println(newn+"/"+newd);
		
	}
	public static void subt(int n1,int d1,int n2,int d2)
	{
		
		
		int newd = lcm(d1,d2);
		int newn = n1*(newd/d1) - n2*(newd/d2) ;
		int temgcd = gcd(newn,newd);
		newd = newd/temgcd;
		newn = newn/temgcd;
		System.out.println("ur fraction is");
		System.out.println(newn+"/"+newd);
		
	}
	public static void multiply(int n1,int d1,int n2,int d2)
	{
		
		
		int newd = d1*d2;
		int newn = n1*n2;
		int temgcd = gcd(newn,newd);
		newd = newd/temgcd;
		newn = newn/temgcd;
		System.out.println("ur fraction is");
		System.out.println(newn+"/"+newd);
		
	}
	public static void divide(int n1,int d1,int n2,int d2)
	{
		
		
		int newd = d1*n2;
		int newn = n1*d2;
		int temgcd = gcd(newn,newd);
		newd = newd/temgcd;
		newn = newn/temgcd;
		System.out.println("ur fraction is");
		System.out.println(newn+"/"+newd);
		
	}
	
	
	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("enter the numerator for first number");
			int n1 = s.nextInt();
			System.out.println("enter the denominator for first number");
			int d1 = s.nextInt();
			System.out.println("enter the numerator for second number");
			int n2 = s.nextInt();

			System.out.println("enter the denominator for second number");
			int d2 = s.nextInt();
			
		
		System.out.println("1. addition");
		System.out.println("2. subtraction");
		System.out.println("3. multiplication");
		System.out.println("4. division");
		System.out.println("what operation do u want to do");
		int cs = s.nextInt();
		
		switch(cs) 
		{
		case 1:
		{
			addition(n1,d1,n2,d2);
			break;
		}
		case 2:
		{
			subt(n1,d1,n2,d2);
			break;
		}
		case 3:
		{
			multiply(n1,d1,n2,d2);
			break;
		}
		case 4:
		{
			divide(n1,d1,n2,d2);
			break;
		}
		 default:
		{
			System.out.println("wrong input");
			break;
		}
		}
		}

		
	}

}
