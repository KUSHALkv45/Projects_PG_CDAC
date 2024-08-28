package assignment.in;

import java.util.Scanner;

public class TollBooth {
    private String type;
    private int numberOfAxles;
    private double distance;
    private double totalFee;
    private double dueAmount;

    public double calculateToll() {
        if (type.equalsIgnoreCase("truck")) {
            totalFee = distance * 0.50 * numberOfAxles;
        } else {
            totalFee = distance * 0.25 * numberOfAxles;
        }
        return totalFee;
    }

    public double generateBill() {
        dueAmount = totalFee + 2;
        return dueAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TollBooth tollBooth = new TollBooth();

            System.out.println("Enter the type of vehicle (possible categories are: truck, car, bus, and van):");
            String type = scanner.nextLine();
            tollBooth.setType(type);

            System.out.println("Enter the number of axles:");
            int numberOfAxles = scanner.nextInt();
            tollBooth.setNumberOfAxles(numberOfAxles);

            System.out.println("Enter the distance traveled:");
            double distance = scanner.nextDouble();
            tollBooth.setDistance(distance);

            double totalFee = tollBooth.calculateToll();
            System.out.println("Total toll fee: $" + totalFee);

            double dueAmount = tollBooth.generateBill();
            System.out.println("Due amount (including $2 processing fee): $" + dueAmount);
        }
    }
}
