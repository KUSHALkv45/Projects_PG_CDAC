package assign8.com;

import java.util.Scanner;

public class salescompany {
	static Scanner s = new Scanner(System.in);
	String name;
	int sales;
	int ID ;
	static int totalsales = 0;
	public void adds()
	{
		System.out.println("Enter the name for salesman");
		this.name = s.next();
		System.out.println("Enter the ID for salesman");
		this.ID = s.nextInt();
		System.out.println("Enter the total sales for this salesman");
		this.sales = s.nextInt();
		totalsales += this.sales;
	}
	public void update()
	{
		System.out.println("u wan to add or subtract 1.for subtract sales 2. for adding sales");
		int choice = s.nextInt();
		if(choice==1)
		{
			System.out.println("enter the number u want to subtract sales");
			int temp = s.nextInt();
			this.sales -= temp;
			totalsales -= temp;
		}
		else if(choice==2)
		{
			System.out.println("enter the number u want to add sales");
			int temp = s.nextInt();
			this.sales += temp;
			totalsales += temp;
		}
		else
		{
			System.out.println("u entered a wrong value its right above and ur dumb");
			
		}
	}
	public void viewsales()
	{
		System.out.println("SALES FOR UR SALESMAN: "+ this.sales);
	}
	public static void totalsales()
	{
		System.out.println("TOTAL SALES :"+ totalsales);
	}
	public static void main(String[] args) {
		salescompany [] sa = new salescompany[30];
		int count =0;
		int choice;
		do
		{
			
		
		System.out.println("1. Add new salesperson");
		System.out.println("2. update a existing salesperson");
		System.out.println("3. View total sales for a salesperson");
		System.out.println("4. View total sales for all salesperson");
		System.out.println("5. Exit");
		System.out.println("Enter ur choice");
		choice = s.nextInt();
		switch(choice)
		{
		case 1:
		{
			sa[count] = new salescompany();
			sa[count].adds();
			count++;
			break;
		}
		case 2:
		{
			System.out.println("Enter the sales id");
			int sID = s.nextInt();
			boolean b =false;
			for(int i =0;i<count;i++)
			{
				if(sID == sa[i].ID)
				{
					b = true;
					sa[i].update();
					break;
				}
				else
				{
					continue;
				}
			}
			if(!b)
			{
				System.out.println("ID not found u dummmy check");
			}
			
			break;
			
		}
		case 3:
		{
			System.out.println("Enter the sales id");
			int sID = s.nextInt();
			boolean b =false;
			for(int i =0;i<count;i++)
			{
				if(sID == sa[i].ID)
				{
					b = true;
					sa[i].viewsales();
					break;
				}
				else
				{
					continue;
				}
			}
			if(!b)
			{
				System.out.println("ID not found u dummmy check");
			}
			
			break;
		}
		case 4:
		{
			totalsales();
			break;
		}
		case 5:
		{
			System.out.println("Thank you For EATING MY BRAIN");
			break;
		}
		default:
		{
			System.out.println("wrong input Donkey are u blind or what");
			break;
		}
		}
		
	}while(choice!=5);

}
}
