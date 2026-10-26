package ca1_algorithms.constructs;

/**
 * StorageInterface defines the contract for Fast-Food storage data structures.
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
     * Displays all food items currently inside the storage structure.
     */
    void display();

    /**
     * Searches for a food item by its name.
     * @param foodName The name of the food item to find.
     */
    void search(String foodName);

    /**
     * Views the food tray currently at the top/front of the storage.
     */
    void peek();
}
