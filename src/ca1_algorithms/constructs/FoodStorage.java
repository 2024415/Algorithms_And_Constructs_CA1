/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_algorithms.constructs;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Main menu-driven driver application for the Fast-Food Storage System.
 * Demonstrates abstraction, polymorphism, error handling, and data structures (Stack & Circular Queue).
 * 
 * @author Dylan, Gabriel L
 */
public class FoodStorage {

    // Reads a whole number safely - keeps asking until the user types a valid integer
    public static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("⚠ Please enter a valid whole number: ");
            }
        }
    }
    
    // Shows the top/front tray of ANY storage (works for Stack and CircularQueue - polymorphism)
    public static void printTop(StorageInterface storage) {
        FoodTray top = storage.peek();
        if (top != null) {
            System.out.println("Top/Front element: " + top.getName() + " (" + top + ")");
        }
    }

    // Helper method to get and validate food tray details from the user
    public static FoodTray getFoodItem(Scanner sc) {

        System.out.println("\nEnter details for food item:");

        // 1. Name check (5 allowed fast-food items)
        System.out.print("Name (Burger, Pizza, Fries, Sandwich, Hotdog): ");
        String name = sc.nextLine().trim();
        if (!name.equalsIgnoreCase("Burger") && !name.equalsIgnoreCase("Pizza") &&
            !name.equalsIgnoreCase("Fries") && !name.equalsIgnoreCase("Sandwich") &&
            !name.equalsIgnoreCase("Hotdog")) {
            System.out.println("⚠ Invalid food item! Setting to default: Burger.");
            name = "Burger";
        }
        
        // 2. Weight check (grams > 0)
        System.out.print("Weight (grams): ");
        double weight;
        try {
            weight = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            weight = 0; // not a number - caught by the check below
        }
        if (weight <= 0) {
            System.out.println("⚠ Invalid weight! Setting to default: 100g.");
            weight = 100;
        }
        
        // 3. Best-before date check (maximum of 2 weeks from today)
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
            System.out.println("⚠ Invalid date range! Setting to max 2 weeks.");
            date = LocalDate.now().plusWeeks(2);
        }

        return new FoodTray(name, weight, date);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int size = 8; // Maximum capacity of the storage is 8 trays

        Stack stack = new Stack(size);
        CircularQueue q = new CircularQueue(size);

        while (true) {
            System.out.println("\n==================================");
            System.out.println("--- Fast-Food Storage Main Menu ---");
            System.out.println("==================================");
            System.out.println("1. Stack Operations (Front Side Add & Remove)");
            System.out.println("2. Queue Operations (Front Add, Opposite Side Remove)");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int mode = readInt(sc);
       
            if (mode == 1) {
                // STACK MENU
                while (true) {
                    System.out.println("\n--- Stack Menu (LIFO) ---");
                    System.out.println("1. Push (Add item)");
                    System.out.println("2. Pop (Remove item)");
                    System.out.println("3. Peek (View top item)");
                    System.out.println("4. Display Stack");
                    System.out.println("5. Search Food Item");
                    System.out.println("6. Back to Main Menu");
                    System.out.print("Enter your choice (1-6): ");
                    int choice = readInt(sc);

                    if (choice == 6) break;

                    switch (choice) {
                        case 1:
                            FoodTray val = getFoodItem(sc);
                            stack.push(val);
                            break;
                        case 2:
                            FoodTray popped = stack.pop();
                            if (popped != null) System.out.println("Popped: " + popped);
                            break;
                        case 3:
                            printTop(stack);
                            break;
                        case 4:
                            stack.display();
                            break;
                        case 5:
                            System.out.print("Enter food name to search: ");
                            stack.search(sc.nextLine());
                            break;
                        default:
                            System.out.println("⚠ Invalid choice, try again.");
                    }
                }
            } else if (mode == 2) {
                // QUEUE MENU
                while (true) {
                    System.out.println("\n--- Circular Queue Menu (FIFO) ---");
                    System.out.println("1. Enqueue (Add item)");
                    System.out.println("2. Dequeue (Remove item)");
                    System.out.println("3. Peek (View front item)");
                    System.out.println("4. Display Queue");
                    System.out.println("5. Queue Size");
                    System.out.println("6. Search Food Item");
                    System.out.println("7. Back to Main Menu");
                    System.out.print("Choose an operation (1-7): ");
                    int choice = readInt(sc);

                    if (choice == 7) break;

                    switch (choice) {
                        case 1:
                            FoodTray item = getFoodItem(sc);
                            q.enqueue(item);
                            break;
                        case 2:
                            FoodTray removed = q.dequeue();
                            if (removed != null) System.out.println("Dequeued: " + removed);
                            break;
                        case 3:
                            printTop(q);
                            break;
                        case 4:
                            q.display();
                            break;
                        case 5:
                            q.size();
                            break;
                        case 6:
                            System.out.print("Enter food name to search: ");
                            q.search(sc.nextLine());
                            break;
                        default:
                            System.out.println("⚠ Invalid choice! Please try again.");
                    }
                }
            } else if (mode == 3) {
                System.out.println("Exiting program. Goodbye!");
                sc.close();
                return;
            } else {
                System.out.println("⚠ Invalid choice, try again.");
            }
        }
    }
}
