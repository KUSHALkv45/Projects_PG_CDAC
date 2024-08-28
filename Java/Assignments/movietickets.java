package assign8.com;

import java.util.Scanner;

public class movietickets {
	public static boolean[][] b = new boolean[5][5];
	public static Scanner s = new Scanner(System.in);
	private static int count = 0;
	public static void availableseats()
	{
		for(int i = 0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(b[i][j]==false)
				{
					System.out.print("#");
				}
				else
				{
				    System.out.print("B");	
				}
				
			}
			System.out.println();
			System.out.println("-------");
		}
	}
	public static void booktickets()
	{
		availableseats();
		System.out.println("based on the seats how many seats u wanna book");
		int no_of_seats = s.nextInt();
		for(int i =0;i<no_of_seats;i++)
		{
			System.out.println("tell us which seat u wanna book enter row number and column number ");
			System.out.println("first row number");
			int row = s.nextInt();
			System.out.println("now enter column number");
			int column = s.nextInt();
			b[row-1][column-1] = true;
			count++;
		}
	}
	private static void ownerview()
	{
		
		
		System.out.println(count+" seats have been booked");
	}
	private static void ownervalue()
	
	{
		
		System.out.println(count*250 +" rs" );
	}
	public static void main(String[] args) {
		
	int choice;
		do
		{
		System.out.println("welcome to assignment movie time");
		System.out.println("1. show available seats");
		System.out.println("2. book movie seats");
		System.out.println("3. count for how many seats are booked");
		System.out.println("4. total money collected");
		System.out.println("5. exit");
		
		choice = s.nextInt();
		switch(choice)
		{
		case 1: 
		{
		 availableseats();
		 break;
		}
		case 2:
		{
			booktickets();
			break;
		}
		case 3:
		{
			ownerview();
			break;
		}
		case 4:
		{
			ownervalue();
			break;
		}
		case 5:
		{
			System.out.println("thanks for watching a movie in this tight schedule now ur fucked up");
			break;
		}
		default:
		{
			System.out.println("wrong input buddy ur dumb or what look at the screen clearly ");
			break;
		}
		
		}
		
	}while(choice!=5);
	

}
}
