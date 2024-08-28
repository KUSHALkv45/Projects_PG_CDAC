package assignment.in;

import java.util.Scanner;

public class bmi {
	double height;
	double weight;
	public bmi(double h,double w)
	{
		this.height = h;
		this.weight = w;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public void bmivalue()
	{
		double answer = weight/(height*height);
		System.out.println(answer);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the height and weight");
		double h = s.nextDouble();
		double w = s.nextDouble();
		
		bmi cal = new bmi(h,w);
		cal.bmivalue();
		
		s.close();
		
		
	}

}
