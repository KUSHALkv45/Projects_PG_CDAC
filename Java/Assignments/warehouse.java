package assign8.com;

import java.util.Scanner;

public class warehouse {
	public static Scanner s = new Scanner(System.in);
	public static int [] countlabel = new int[5];
public static String [][] inventory = new String[5][10];	
public static void add()
{
	System.out.println("enter the shelf no you want to enter ur item 1-5");
	int shelfno = s.nextInt();
	System.out.println("enter the name of  your item");
	String i_name = s.next();
	if(countlabel[shelfno-1]>=10)
	{
		System.out.println("size limit reached kindly leave the server");
	}
	else 
	{
		
		inventory[shelfno-1][countlabel[shelfno-1]++] = i_name;
	}
	
}
public static void remove()
{   
	System.out.println("enter the shelf no you want to remove ur item 1-5");
    int shelfno = s.nextInt();
    System.out.println("enter the name of  your item u want to remove");
	String i_name = s.next();
	boolean x = false;
	for(int i =0;i<(countlabel[shelfno-1]);i++)
	{
		if(i_name.equals(inventory[shelfno-1][i]))
		{
			inventory[shelfno-1][i] ="";
			x = true;
			break;
			
			
		}
		else
		{
			continue;
		}
	}
    if(!x)
    {
    	System.out.println("wrong name entered");
    }
	
}
public static void display()
{
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<countlabel[i];j++)
		{
			System.out.print(inventory[i][j]);
		}
		System.out.println();
	}
}


public static void main(String[] args) {
	int choice;
	do
		{System.out.println("1. add a item to a shelf");
		
		
	System.out.println("2. remove an item from a shelf");
	System.out.println("3. Display all contents ");
	System.out.println("4. Exit");
	System.out.println("Enter ur choice");
	choice = s.nextInt();
	switch(choice)
	{
	case 1:
	{
		add();
		break;
	}
	case 2:
	{
		remove();
		break;
	}
	case 3:
	{
		display();
		break;
	}
	case 4:
	{
		System.out.println("SAYONARA !!!");
		break;
	}
	case 5:
	{
		System.out.println("entered a wrong input lil bro");
		break;
	}
	}
		}while(choice!=4);
}

}
