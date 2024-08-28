package assignment.in;

import java.util.Scanner;

public class bank_account {
	/*Create a new account 
	b. Deposit money into an account 
	c. Withdraw money from an account 
	d. Display the account balance 
	e. Display the account holder's information
                                                  
      
	Account holder's name (String) 
	b. Account number (int) 
	Designed by Sandeep Kulange 
	Core Java Assignment 2 
	c. Account balance (double)   */
	static int a =1;
	int Acn ;
	String Name;
	double balance;
	public bank_account(String d,double b)
	{
		this.Acn = a++;
		this.Name = d;
		this.balance = b;
		
		
		
	}
	public void deposit()
	{
		try( Scanner s = new Scanner(System.in))
		{
			
		
		System.out.println("enter the amount u want to deposit");
		double money = s.nextDouble();
		this.balance = this.balance + money;
		}
		
	}
	public void display()
	{
		
		System.out.println(this.balance);
	}
	public void accdetails()
	{
		System.out.println(this.Acn);
		System.out.println(this.Name);
		System.out.println(this.balance);
		System.out.println(this.balance);
		
	}
	public static void main(String[] args) {
		bank_account a1 = new bank_account("1st acc",50000.5);
		bank_account a2 = new bank_account("2nd acc",750000.75);
		a1.accdetails();
		a2.accdetails();
		
		
	}
	
	
}
