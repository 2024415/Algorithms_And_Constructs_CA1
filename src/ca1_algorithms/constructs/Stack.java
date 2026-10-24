/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1_algorithms.constructs;

/**
 *
 * @author Dylan
 */
public class Stack implements StorageInterface {
    private FoodTray[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        arr = new FoodTray[size];
        capacity = size;
        top = -1;
    }
}
    