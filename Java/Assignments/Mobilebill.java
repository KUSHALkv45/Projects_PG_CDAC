package assignment.in;

public class Mobilebill {
	
	String Name;
	long phonenumber;
	int number_of_calls_made;
	double Duration;
	public Mobilebill(String a,long b, int c,double d)
	{
		this.Name = a;
		this.Duration = d;
		this.number_of_calls_made = c;
		this.phonenumber = b;
	}
	public void bill()
	{
		double bamount;
		if(number_of_calls_made<=100)
		{
		 bamount = 10 +  number_of_calls_made*0.5;
		System.out.println("Hi Mr "+ Name + " ur mobile bill u have spoke like chatterbox u idot");
		System.out.println(bamount);
		}
		else
		{
			 bamount = 10 +  (number_of_calls_made-100)*0.25 + 100*0.5;
			System.out.println("Hi Mr "+ Name + " ur mobile bill u have spoke like chatterbox u idot");
			System.out.println(bamount);
		}
	}
	public static void main(String[] args) {
		Mobilebill n1 = new Mobilebill("bEP",89283948999L,289,250.5);
		n1.bill();
	}

}
