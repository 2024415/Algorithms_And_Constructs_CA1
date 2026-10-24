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
 */
// Child class inheriting from MenuItem
public class FoodTray extends MenuItem {
    private LocalDate bestBeforeDate;
    private LocalDateTime placedTime;

    public FoodTray(String name, double weightGrams, LocalDate bestBeforeDate) {
        super(name, weightGrams);
        this.bestBeforeDate = bestBeforeDate;
        this.placedTime = LocalDateTime.now(); // Auto-stamped from FoodStorage.java
