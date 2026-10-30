/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1_algorithms.constructs;

/**
 *
 * @author Dylan
 */
// Abstract parent class demonstrating Inheritance & Encapsulation
public abstract class MenuItem {
    private String name;
    private double weightGrams;

    public MenuItem(String name, double weightGrams) {
        this.name = name;
        this.weightGrams = weightGrams;
    }

    public String getName() { return name; }
    public double getWeightGrams() { return weightGrams; }
    public abstract String getItemDetails();
}
