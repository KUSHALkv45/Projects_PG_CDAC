package assign8.com;

import java.util.Scanner;

public class flights {
	 
	public static String [] flight = {"Kingfisher","AirIndia","Spicejet","vistara","AirAsia","QatarAirways"};
	public static int [] available = {4,5,3,2,7,9};
	String flightreserved;
	String name;
	private String password;
	static Scanner s = new Scanner(System.in);
	public void registration()
	{
		System.out.println("enter ur name");
		this.name = s.next();
		System.out.println("enter ur password");
		this.password = s.next();
		
	}
	public  static void availability()
	{
		for(int i = 0;i<6;i++)
		{
			if(available[i]!=0)
			{
				System.out.println(flight[i]+" and no of avialable seats are " + available[i]);
			}
		}
	}
	public  void seatreservation()
	{
		availability();
		boolean x = false;
		System.out.println("enter the filght which u want to book");
		String str = s.next();
		for(int i=0;i<6;i++)
		{
			if(str.equals(flight[i]))
			{
				this.flightreserved = str;
				x = true;
				if(available[i]!=0)
				{
				available[i]--;
				break;
				}
				else
				{
					System.out.println("no availability for this flight");
				}
			}
			else
			{
				continue;
			}
		}
		if(!x)
		{
			System.out.println("enter a valid flight name");
		}
		
		
	}
	public void reservations()
	{
		if(this.flightreserved !=null)
		{
			System.out.println(this.flightreserved);
		}
		else
		{
			System.out.println("no reservations");
		}
	}
	public void cancel()
	{
		if(this.flightreserved !=null)
		{
			for(int i =0;i<6;i++)
			{
				if(this.flightreserved.equals(flight[i]))
				{
					this.flightreserved ="";
					available[i]--;
					
				}
			}
		}
		else
		{
			System.out.println("no reservations");
		}
	}
	
	
	public static void main(String[] args) {
		flights user = new flights();
		int choice ;
		do
		{
			
		
		System.out.println("1. user registration");
		System.out.println("2. Flight availability");
		System.out.println("3. Seat reservation");
		System.out.println("4. View reservations");
		System.out.println("5. Cancel reservations");
		System.out.println("6. exit");
		System.out.println("enter the operation required");
		
		 choice = s.nextInt();
		switch(choice)
		{
		case 1:
		{
			user.registration();
			break;
		}
		case 2:
		{
			availability();
			break;
		}
		case 3:
		{
			user.seatreservation();
			break;
		}
		case 4:
		{
			user.reservations();
			break;
		}
		case 5:
		{
			user.cancel();
			break;
		}
		case 6:
		{
			System.out.println("bye bye ");
		}
		default:
		{
			System.out.println("wrong input");
		}
		}
		}while(choice!=6);
		
		
	}
}
