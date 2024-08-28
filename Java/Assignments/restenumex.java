package assign8.com;

/*
 
  
a. Define an enumeration called Dish that contains a list of dishes offered by the 
restaurant. Each dish should have a name and a price associated with it. 
b. Implement a method called printMenu that prints the list of dishes along with 
their prices on the console. 
c. Implement a method called takeOrder that prompts the user to select a dish 
from the menu and specify the quantity they wish to order. The method 
should return the total cost of the order. 
d. The program should continue to take orders until the user chooses to exit. 
e. When the user exits, the program should print a summary of all the orders 
taken, including the name of the dish, quantity, and total cost. 
 
 
 */

import java.util.Scanner;

//Define an enumeration called Dish
enum Dishe {
 PIZZA("Pizza", 10.99),
 BURGER("Burger", 8.99),
 PASTA("Pasta", 12.99),
 SALAD("Salad", 6.99),
 SANDWICH("Sandwich", 7.99);

 private final String name;
 private final double price;

 // Constructor
 Dishe(String name, double price) {
     this.name = name;
     this.price = price;
 }

 // Getter methods
 public String getName() {
     return name;
 }

 public double getPrice() {
     return price;
 }
}

public class restenumex {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     boolean ordering = true;
     double totalCost = 0;

     System.out.println("Welcome to the restaurant menu ordering system!");

     while (ordering) {
         printMenu();

         System.out.print("Enter the dish number you want to order (or 0 to exit): ");
         int choice = scanner.nextInt();

         if (choice == 0) {
             ordering = false;
         } else if (choice >= 1 && choice <= Dishe.values().length) {
             Dishe selectedDish = Dishe.values()[choice - 1];
             System.out.print("Enter the quantity for " + selectedDish.getName() + ": ");
             int quantity = scanner.nextInt();

             double dishCost = selectedDish.getPrice() * quantity;
             totalCost += dishCost;
             System.out.println("Added " + quantity + " " + selectedDish.getName() + "(s) to your order. Cost: $" + dishCost);
         } else {
             System.out.println("Invalid choice. Please select a valid dish number.");
         }
     }

     System.out.println("Thank you for ordering!");
     System.out.println("Total cost of your order: $" + totalCost);

     scanner.close();
 }

 // Method to print the menu
 public static void printMenu() {
     System.out.println("\nMenu:");
     int i = 1;
     for (Dishe dish : Dishe.values()) {
         System.out.println(i + ". " + dish.getName() + " - $" + dish.getPrice());
         i++;
     }
 }
}
