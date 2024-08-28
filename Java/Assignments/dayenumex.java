package assign8.com;

import java.util.Scanner;

enum dayenumex {
	SUNDAY,
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY;
	
 public static void getday(dayenumex x)
 {
	 System.out.println(x);
 }
 public static void getnextday(dayenumex x)
 {
	 int nextindex = (x.ordinal() +1)%7;
	 System.out.println("the next day is "+dayenumex.values()[nextindex]);
 }
 public static void getdaynumber(dayenumex x)
 {
	 System.out.println("the value of ur day is "+ x.ordinal()+1);
 }
 public static void getweekends()
 {
	 System.out.println("weekends are  SATURDAY  and  SUNDAY ") ;
 }



	public static void main(String [] args)
	{
		dayenumex day = null;
		Scanner s = new Scanner(System.in);
		boolean isvalid = false;
		System.out.println("enter the day ");
		String dayi = s.nextLine().toUpperCase();
	while(!isvalid)
		{
		try
		
		{
			day = dayenumex.valueOf(dayi);
			isvalid = true;
		}
		catch (IllegalArgumentException e) 
		{
            System.out.println("Invalid input. Please enter a valid day of the week.");
		}
	}
	getday(day);
	getnextday(day);
	getdaynumber(day);
	getweekends();
	s.close();
}
}
 


