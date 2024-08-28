package date.example;



import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class DateTimeQuestion {
	private int day;
	private int month;
	private int year;
	private int sec;
	private int hour;
	private int min;
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	private Date inputDate;
	Scanner sc = new Scanner(System.in);

	public void setInputDate() {
		this.inputDate = new Date(getYear() - 1900, getMonth() - 1, getDay(), getHour(), getMin(), getSec());
//		this.inputDate = new Date(2024 - 1900, getMonth() - 1, getDay(), getHour(), getMin(), getSec());
	}

	public int getDay() {
		return day;
	}

	public void setDay(int date) {
		this.day = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int time) {
		this.month = time;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	void addDate() {
		System.out.println("Enter date and time\n");
		System.out.print("Day- ");
		setDay(sc.nextInt());
		System.out.print("Month- ");
		setMonth(sc.nextInt());
		System.out.print("Year- ");
		setYear(sc.nextInt());
		System.out.print("Hour- ");
		setHour(sc.nextInt());
		System.out.print("Minute- ");
		setMin(sc.nextInt());
		System.out.print("Second- ");
		setSec(sc.nextInt());
		setInputDate();
	}

	String getFormattedDate(String inputFormat) {
		sdf = new SimpleDateFormat(inputFormat);
		return sdf.format(this.inputDate);
	}

	int getMenuChoice() {
		System.out.println("Change the format");
		System.out.println("1 for dd/MM/yyyy");
		System.out.println("2 for MM/dd/yyyy");
		System.out.println("3 for yyyy/MM/dd");
		System.out.println("4 for HH:mm:ss");
		System.out.println("5 for hh:mm:ss a");
		System.out.println("6 for HH:mm");
		System.out.println("7 for dd/MM/yyyy HH:mm:ss");
		System.out.println("8 for MM/dd/yyyy hh:mm:ss a");
		System.out.println("9 for yyyy/MM/dd HH:mm");
		return sc.nextInt();
	}

	void printInDifferentFormat() {
		int choice;

		while ((choice = getMenuChoice()) != 0) {
			switch (choice) {
			case 1:
				System.out.println("\nFormated date- " + getFormattedDate("dd/MM/yyyy"));
				break;
			case 2:
				System.out.println("\nFormated date- " + getFormattedDate("MM/dd/yyyy"));
				break;
			case 3:
				System.out.println("\nFormated date- " + getFormattedDate("yyyy/MM/dd"));
				break;
			case 4:
				System.out.println("\nFormated date- " + getFormattedDate("HH:mm:ss"));
				break;
			case 5:
				System.out.println("\nFormated date- " + getFormattedDate("hh:mm:ss a"));
				break;
			case 6:
				System.out.println("\nFormated date- " + getFormattedDate("HH:mm"));
				break;
			case 7:
				System.out.println("\nFormated date- " + getFormattedDate("dd/MM/yyyy HH:mm:ss"));
				break;
			case 8:
				System.out.println("\nFormated date- " + getFormattedDate("MM/dd/yyyy hh:mm:ss a"));
				break;
			case 9:
				System.out.println("\nFormated date- " + getFormattedDate("yyyy/MM/dd HH:mm"));
				break;
			}
		}
	}

	public static void main(String[] args) {
		DateTimeQuestion dt = new DateTimeQuestion();
		dt.addDate();
		dt.printInDifferentFormat();
	}

}