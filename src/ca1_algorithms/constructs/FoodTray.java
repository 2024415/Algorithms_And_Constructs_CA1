/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1_algorithms.constructs;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Dylan
 * Models a physical fast-food tray stored in the unit.
 * All getters and object instantiations in this class operate at O(1) Time Complexity.
 */

// Child class inheriting from MenuItem
public class FoodTray extends MenuItem {
    private LocalDate bestBeforeDate;
    private LocalDateTime placedTime;

    public FoodTray(String name, double weightGrams, LocalDate bestBeforeDate) {
        super(name, weightGrams);
        this.bestBeforeDate = bestBeforeDate;
        this.placedTime = LocalDateTime.now(); // Time the tray was placed in storage (auto-stamped from FoodStorage)
    }

    public LocalDate getBestBeforeDate() { return bestBeforeDate; }
    public LocalDateTime getPlacedTime() { return placedTime; }

    @Override
    public String getItemDetails() {
        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s | %.1fg | Best Before: %s | Stored At: %s",
                getName(), getWeightGrams(), bestBeforeDate, placedTime.format(timeFmt));
    }

    @Override
    public String toString() {
        return getItemDetails();
    }
}