package ca1_algorithms.constructs;

/**
 * Shared interface for Stack and CircularQueue storage structures.
 * Demonstrates the Object-Oriented Programming principle of Abstraction.
 * 
 * @author Dylan, Gabriel
 */
public interface StorageInterface {
    
    /**
     * Checks whether the storage unit contains any food trays.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Views the food tray currently at the top/front of the storage.
     * @return FoodTray object at the top/front or null if empty.
     */
    FoodTray peek();

    /**
     * Displays all food items currently inside the storage structure.
     */
    void display();

    /**
     * Searches for a food item by its name.
     * @param foodName The name of the food item to find.
     */
    void search(String foodName);
}
