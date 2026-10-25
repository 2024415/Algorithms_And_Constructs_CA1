/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1_algorithms.constructs;
import java.util.Scanner;
import java.time.LocalDate;

/**
 *
 * @author Dylan
 */
public class FoodStorage {

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
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
