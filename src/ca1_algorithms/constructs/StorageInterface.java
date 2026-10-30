/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1_algorithms.constructs;

/**
 *
 * @author Dylan
 * Shared interface for Stack and CircularQueue storage structures.
 */
// Interface demonstrating Abstraction
public interface StorageInterface {
    boolean isEmpty();
    FoodTray peek();
    void display();
    void search(String foodName);
}
