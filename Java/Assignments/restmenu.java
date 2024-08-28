package assign8.com;

import java.util.Scanner;


public class restmenu {
public static Scanner s = new Scanner(System.in);
public static int choices = 20;
public static String [] dishes = new String[choices];

public static int [] prices =new int[choices];
public static int avi = 10;
public static void viewmenu()
{
	for(int i = 0;i<avi;i++)
	{
		System.out.println("1."+dishes[i]+ "and its price is "+prices[i]);
	}
}
public static void addnewdish()
{
	System.out.println("enter the name of ur new dish");
	String temp = s.next();
	dishes[avi]=temp;
	System.out.println("enter the price for the new dish u added");
	int tempp = s.nextInt();
	prices[avi++] = tempp;
}
public static void removedish()
{
	System.out.println("enter the name of the dish u want to remove");
	String temp = s.next();
	int x = 0;
	boolean r = false;
	for(int i = 0;i<avi;i++)
	{
		if(dishes[i].equals(temp))
		{
			
			r = true;
			x = i;
			
			break;
		}
		else
		{
			continue;
		}
	}
	if(!r)
	{
		System.out.println("the dish u have entered ,we dont have that dish here");
	}
	else
	{
		for(int j = x;j<avi;j++)
		{
			dishes[x] =dishes[x+1];
			prices[x] = prices[x+1];
			avi--;
		}
	}
	
	
}

public static void modifyprice()
{
	System.out.println("enter the name of the dish u want to modify the price for");
	String temp = s.next();
	int x = 0;
	boolean r = false;
	for(int i = 0;i<avi;i++)
	{
		if(dishes[i].equals(temp))
		{
			
			r = true;
			x = i;
			
			break;
		}
		else
		{
			continue;
		}
	}
	if(!r)
	{
		System.out.println("the dish u have entered ,we dont have that dish here");
	}
	else
	{
		System.out.println("enter the price u r going to change it to");
		int temp1 = s.nextInt();
		prices[x]=temp1;
	}
}

public static void main(String[] args) {
	String [] array = 
		{
	    "Butter Chicken",
	    "Chicken Tikka Masala",
	    "Tandoori Chicken",
	    "Rogan Josh",
	    "Palak Paneer",
	    "Chole",
	    "Biryani",
	    "Aloo Gobi",
	    "Masoor Dal",
	    "Naan",
	    
	};
	int [] aaa =
	{400,350,500,400,360,300,450,320,280,60};
	
	for(int i =0;i<array.length;i++)
	{
		dishes[i] = array[i];
		prices[i] = aaa[i];
	}
	 int choice;
	do
	 {
		 
		System.out.println("1. view menu with prices");
		System.out.println("2. add new dish to menu");
		System.out.println("3. remove a dish from menu");
		System.out.println("4. modify a price of a dish from menu");
		System.out.println("5. exit the restaurent");
		choice = s.nextInt();
		switch(choice)
		{
		case 1 :
		{
			viewmenu();
			break;
		}
		case 2:
		{
			addnewdish();
			break;
		}
		case 3:
		{
			removedish();
			break;
		}
		case 4:
		{
			modifyprice();
			break;
		}
		case 5:
		{
		  System.out.println("thank you for visiting");
		  break;
		}
		default:
		{
			System.out.println("enter a valid choice");
		}
		}
	} while( choice != 5);
	 
	 s.close();
	
}
}
