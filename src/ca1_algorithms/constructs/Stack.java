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
    
    // Add tray at Front Side (Push) - Time Complexity: O(1)
    public void push(FoodTray x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
        System.out.println(x.getName() + " pushed to stack.");
    }

    // Remove tray from Front Side (Pop) - Time Complexity: O(1)
    public FoodTray pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top--];
    }

    // View top tray at Front Side (Peek) - Time Complexity: O(1)
    public FoodTray peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[top];
    }    
}
