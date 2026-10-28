/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_algorithms.constructs;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Dylan
 */
public class FoodStorage {

    // Reads a whole number safely - keeps asking until the user types a valid integer
    public static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.print("⚠ Please enter a whole number: ");
            }
        }
    }
    
    // Shows the top/front tray of ANY storage (works for Stack and CircularQueue - polymorphism)
    public static void printTop(StorageInterface storage) {
        FoodTray top = storage.peek();
        if (top != null) System.out.println("Top element: " + top.getName() + " (" + top + ")");
    }

    // Kept exact input prompts and if-statement style from original file
    public static FoodTray getFoodItem(Scanner sc) {

        System.out.println("\nEnter details for food item:");

        // 1. Name check (5 allowed fast-food items)
        System.out.print("Name (Burger, Pizza, Fries, Sandwich, Hotdog): ");
        String name = sc.nextLine().trim();
        if (!name.equalsIgnoreCase("Burger") && !name.equalsIgnoreCase("Pizza") &&
            !name.equalsIgnoreCase("Fries") && !name.equalsIgnoreCase("Sandwich") &&
            !name.equalsIgnoreCase("Hotdog")) {
            System.out.println("⚠ Invalid food! Setting to default: Burger.");
            name = "Burger";
        }
        
        // 2. Weight check (grams > 0)
        System.out.print("Weight (grams): ");
        double weight = sc.nextDouble();
        sc.nextLine(); // clear buffer
        if (weight <= 0) {
            System.out.println("⚠ Invalid weight! Setting to default: 100g.");
            weight = 100;
        }
        
        // 3. Best-before check (max 2 weeks, from original FoodStorage.java)
        System.out.print("Best-before (YYYY-MM-DD, max 2 weeks): ");
        String dateInput = sc.nextLine();

        LocalDate date;
        try {
            date = LocalDate.parse(dateInput.trim());
            } catch (DateTimeParseException e) {
                System.out.println("⚠ Invalid date format!");
                date = LocalDate.now().plusWeeks(3); // forces the 2-week check below
        }

        // Check 2-week limit
        if (date.isAfter(LocalDate.now().plusWeeks(2)) || date.isBefore(LocalDate.now())) {
            System.out.println("⚠ Invalid date! Setting to max 2 weeks.");
            date = LocalDate.now().plusWeeks(2);
        }

        return new FoodTray(name, weight, date);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
