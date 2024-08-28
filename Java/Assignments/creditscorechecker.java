package assignment.in;

public class creditscorechecker {
	int creditHistory;
	double creditUtilization;
	boolean paymentHistory;
	public int getCreditHistory() {
		return creditHistory;
	}
	public void setCreditHistory(int creditHistory) {
		this.creditHistory = creditHistory;
	}
	public double getCreditUtilization() {
		return creditUtilization;
	}
	public void setCreditUtilization(double creditUtilization) {
		this.creditUtilization = creditUtilization;
	}
	public boolean isPaymentHistory() {
		return paymentHistory;
	}
	public void setPaymentHistory(boolean paymentHistory) {
		this.paymentHistory = paymentHistory;
	}
	creditscorechecker(int a,double b,boolean c)
	{
		this.creditHistory = a;
		this.creditUtilization = b;
	     this.paymentHistory = c;
	}
	public void crscore()
	{
		if(this.paymentHistory == true)
		{
			int crs = (int)(this.creditUtilization * 30) + creditHistory*15 + 55;
			System.out.println(crs);
		}
		else
		{
			int crs = (int)(this.creditUtilization * 30) + creditHistory*15 + 35;
			System.out.println(crs);
		}
	}
	public static void main(String[] args) {
		creditscorechecker profile1 = new creditscorechecker(10,77.89,true);
		profile1.crscore();
		
		
	}

}
