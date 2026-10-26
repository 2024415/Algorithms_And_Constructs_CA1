package algorithms_and_constructs_ca1;

import java.util.Scanner;
import java.time.LocalDate;

/**

 * @author Dylan, Gabriel
 */
public class FoodStorage {

    
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
        double weight = 0;
        try {
            weight = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("⚠ Invalid weight format!");
        }
        sc.nextLine(); 

        if (weight <= 0) {
            System.out.println("⚠ Setting weight to default: 100g.");
            weight = 100;
        }

        // 3. Best-before check (max 2 weeks)
        System.out.print("Best-before (YYYY-MM-DD, max 2 weeks): ");
        String dateInput = sc.nextLine();
        LocalDate date;

        try {
            date = LocalDate.parse(dateInput);
            if (date.isAfter(LocalDate.now().plusWeeks(2)) || date.isBefore(LocalDate.now())) {
                System.out.println("⚠ Date out of range (max 2 weeks)! Setting to max limit.");
                date = LocalDate.now().plusWeeks(2);
            }
        } catch (Exception e) {
            System.out.println("⚠ Invalid date format! Setting to default (2 weeks from today).");
            date = LocalDate.now().plusWeeks(2);
        }

        return new FoodTray(name, weight, date);
    }

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

            int mode = 0;
            try {
                mode = sc.nextInt();
            } catch (Exception e) {
                System.out.println("⚠ Input must be a number!");
            }
            sc.nextLine(); 

            if (mode == 1) {
                
                while (true) {
                    System.out.println("\n--- Stack Menu (LIFO) ---");
                    System.out.println("1. Push (Add item)");
                    System.out.println("2. Pop (Remove item)");
                    System.out.println("3. Peek (View top item)");
                    System.out.println("4. Display Stack");
                    System.out.println("5. Search Food Item");
                    System.out.println("6. Back to Main Menu");
                    System.out.print("Enter your choice (1-6): ");

                    int choice = 0;
                    try {
                        choice = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("⚠ Input must be a number!");
                    }
                    sc.nextLine(); 

                    if (choice == 6) break;

                    switch (choice) {
                        case 1:
                            if (stack.isFull()) {
                                System.out.println("Stack Overflow");
                            } else {
                                FoodTray val = getFoodItem(sc);
                                stack.push(val);
                            }
                            break;
                        case 2:
                            FoodTray popped = stack.pop();
                            if (popped != null) {
                                System.out.println("Popped: " + popped);
                            }
                            break;
                        case 3:
                            FoodTray top = stack.peek();
                            if (top != null) {
                                System.out.println("Top element: " + top.getName() + " (" + top + ")");
                            }
                            break;
                        case 4:
                            stack.display();
                            break;
                        case 5:
                            System.out.print("Enter food name to search: ");
                            stack.search(sc.nextLine());
                            break;
                        default:
                            System.out.println("⚠ Invalid choice! Please select 1-6.");
                    }
                }
            } else if (mode == 2) {
               
                while (true) {
                    System.out.println("\n--- Circular Queue Menu (FIFO) ---");
                    System.out.println("1. Enqueue (Add item)");
                    System.out.println("2. Dequeue (Remove item)");
                    System.out.println("3. Peek (View front item)");
                    System.out.println("4. Display Queue");
                    System.out.println("5. Queue Size");
                    System.out.println("6. Search Food Item");
                    System.out.println("7. Back to Main Menu");
                    System.out.print("Enter your choice (1-7): ");

                    int choice = 0;
                    try {
                        choice = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("⚠ Input must be a number!");
                    }
                    sc.nextLine(); 

                    if (choice == 7) break;

                    switch (choice) {
                        case 1:
                            FoodTray item = getFoodItem(sc);
                            q.enqueue(item);
                            break;
                        case 2:
                            q.dequeue();
                            break;
                        case 3:
                            q.peek();
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
                            System.out.println("⚠ Invalid choice! Please select 1-7.");
                    }
                }
            } else if (mode == 3) {
                System.out.println("Exiting application. Goodbye!");
                sc.close();
                return;
            } else {
                System.out.println("⚠ Invalid choice! Please select 1, 2, or 3.");
            }
        }
    }
}
