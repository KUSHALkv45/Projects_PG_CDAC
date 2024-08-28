package assignment.in;

public class ElectricityBill {
	
	String customerName;
	double unitsconsumed;
	double billAmount;
	public ElectricityBill(String a , double b )
	{
		this.customerName = a;
		this.unitsconsumed = b;
		
	}
	public String getCustomerName() {
	
		System.out.println("Enter ur name");
		
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getUnitsconsumed() {
		return unitsconsumed;
	}
	public void setUnitsconsumed(double unitsconsumed) {
		this.unitsconsumed = unitsconsumed;
	}
	public void bill()
	{
		double bill;
	
		if(this.unitsconsumed<100)
		{
			 bill = unitsconsumed*5;
			 System.out.println("hi Mr."+this.customerName+" your bizli ka bill which u have to pay not ur bapp");
			 
			System.out.println(bill);
		}
		else if(unitsconsumed>100 && unitsconsumed<300)
		{
			 bill = 100*5 + (unitsconsumed-100)*7;
			 System.out.println("hi Mr."+this.customerName+" your bizli ka bill which u have to pay not ur bapp");
			System.out.println(bill);
		}
		else
		{
			bill = 100*5 + (unitsconsumed-300)*10 + 200*7;
			System.out.println("hi Mr."+this.customerName+" your bizli ka bill which u have to pay not ur bapp");
			System.out.println(bill);
		}
	}
	public static void main(String[] args) {
		ElectricityBill E1 = new ElectricityBill("some rkep",5.55);
		E1.bill();
		
	}
	

}
