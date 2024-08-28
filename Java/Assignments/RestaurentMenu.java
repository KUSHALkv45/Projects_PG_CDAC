package assign8.com;

import java.util.Scanner;

//Define an enumeration called Dish
enum Dish {
 PIZZA("Pizza", 10.99),
 BURGER("Burger", 8.99),
 PASTA("Pasta", 12.99),
 SALAD("Salad", 6.99),
 SANDWICH("Sandwich", 7.99);

 private final String name;
 private final double price;

 // Constructor
 Dish(String name, double price) {
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

public class RestaurentMenu {
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
         } else if (choice >= 1 && choice <= Dish.values().length) {
             Dish selectedDish = Dish.values()[choice - 1];
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
     for (Dish dish : Dish.values()) {
         System.out.println(i + ". " + dish.getName() + " - $" + dish.getPrice());
         i++;
     }
 }
}
