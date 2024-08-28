package assignment.in;

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
	static Calendar c = new GregorianCalendar();
	static Scanner s = new Scanner(System.in);
	int day;
	int year;
	int month;
	Date(int a , int b, int c)
	{
		this.day = a;
		this.year = c;
		this.month = b;
	}
	public void isvalid()
	{
		if(month>=1 && month<=12)
		{
		if(this.month==1 || this.month==3 || this.month==5 || this.month==7 || this.month==8 || this.month==10 || this.month==12)
		{
			if(this.day<=31 && this.day>=1)
			{
				System.out.println("valid");
			}
			else
			{
				System.out.println("Not a valid date");
			}
		}
		else if(this.month==2)
		{
			if(!this.leapyear())
			{
			if(this.day>=1 && this.day<=28)
			{
				System.out.println("valid date");
			}
			else 
			{
				System.out.println("not a valid date");
			}
			}
			else
			{
				if(this.day>=1 && this.day<=29)
				{
					System.out.println("valid date");
				}
				else
				{
					System.out.println("not a valid date");
				}
			}
			
		}
		else
		{
			if(this.day>=1 && this.day<=30)
			{
				System.out.println("valid date");
			}
			else
			{
				System.out.println("not a valid date");
			}
		}
		}
		else
		{
			System.out.println("not a valid date");
		}
	}
	else 
	{
		System.out.println("Not a valid year");
	}
}
	public boolean leapyear()
	{
		if(this.year %400 == 0)
		{
			return true;
		}
		else if(this.year % 4 == 0 && this.year%100 == 0)
		{
			return false;
		}
		else if(this.year % 4 ==0 && this.year % 100 !=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void getday_of_weak()
	{
		if(isvalid())
		{

		
	  c.set(this.year,this.month-1,this.day);
	  int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	  String dayName = "";
      switch (dayOfWeek) {
          case Calendar.SUNDAY:
              dayName = "Sunday";
              break;
          case Calendar.MONDAY:
              dayName = "Monday";
              break;
          case Calendar.TUESDAY:
              dayName = "Tuesday";
              break;
          case Calendar.WEDNESDAY:
              dayName = "Wednesday";
              break;
          case Calendar.THURSDAY:
              dayName = "Thursday";
              break;
          case Calendar.FRIDAY:
              dayName = "Friday";
              break;
          case Calendar.SATURDAY:
              dayName = "Saturday";
              break;
      }

      System.out.println("The day of the week for the given date is: " + dayName);
	}
	else{
		System.out.println("Not a valid date");
	}
  }
	  
	
	public void nextday()

	{
		if()
		c.set(this.year,this.month-1,this.day);
		  int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		  String dayName = "";
	      switch (dayOfWeek) {
	          case Calendar.SUNDAY:
	              dayName = "Monday";
	              break;
	          case Calendar.MONDAY:
	              dayName = "Tuesday";
	              break;
	          case Calendar.TUESDAY:
	              dayName = "Wednesday";
	              break;
	          case Calendar.WEDNESDAY:
	              dayName = "Thursday";
	              break;
	          case Calendar.THURSDAY:
	              dayName = "Friday";
	              break;
	          case Calendar.FRIDAY:
	              dayName = "Saturday";
	              break;
	          case Calendar.SATURDAY:
	              dayName = "Sunday";
	              break;
	      }

	      System.out.println("The Next day of the week for the given date is: " + dayName);
	}
	
	public void previous_day()
	{
		c.set(this.year,this.month-1,this.day);
		  int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		  String dayName = "";
	      switch (dayOfWeek) {
	          case Calendar.SUNDAY:
	              dayName = "Saturday";
	              break;
	          case Calendar.MONDAY:
	              dayName = "Sunday";
	              break;
	          case Calendar.TUESDAY:
	              dayName = "Monday";
	              break;
	          case Calendar.WEDNESDAY:
	              dayName = "Tuesday";
	              break;
	          case Calendar.THURSDAY:
	              dayName = "Wednesday";
	              break;
	          case Calendar.FRIDAY:
	              dayName = "Thursday";
	              break;
	          case Calendar.SATURDAY:
	              dayName = "Friday";
	              break;
	      }

	      System.out.println("The Previous day of the week for the given date is: " + dayName);
	}
	
		
		
	
	public static void main(String[] args) {
		
		System.out.println("enter the date");
		int d = s.nextInt();
		System.out.println("enter the month");
		int m = s.nextInt();
		System.out.println("enter the year");
		int y = s.nextInt();
		Date d1 = new Date(d,m,y);
do
{


		System.out.println("enter ur choice");
		System.out.println("1.isValid");
		System.out.println("2. getDayOfWeek");
		System.out.println("3. isLeapYear");
		System.out.println("4.getNextDay");
		System.out.println("5.getPreviousDay");
		int choice = s.nextInt();
	
		switch(choice)
		{
			case 1 :
			{
				d1.isvalid();
				break;
			}
			case 2:
			{
				d1.getday_of_weak();
				break;
			}
			case 3:
			{
				d1.leapyear();
				break;
			}
			case 4:
			{
				d1.nextday();
				break;
			}
			case 5:
			{
				d1.previous_day();
				break;
			}
		
			default :
			{
				System.out.println("enter a valid choice next time u fool when u run");
				break;
			}
		}
	}
	while(choice!=0);
		
	}
}
