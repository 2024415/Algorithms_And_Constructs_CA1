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

    // Check if full (8 trays max) - Time Complexity: O(1)
    public boolean isFull() {
        return top == capacity - 1;
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
    @Override
    public FoodTray peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[top];
    }    
    
   // Check if empty - Time Complexity: O(1)
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    // Display all trays in Stack - Time Complexity: O(n)
    @Override
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }

    // Linear search by food name - Time Complexity: O(n)
    @Override
    public void search(String name) {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        boolean found = false;
        for (int i = 0; i <= top; i++) {
            if (arr[i].getName().equalsIgnoreCase(name.trim())) {
                System.out.println("Found: " + arr[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Food item not found: " + name);
        }
    }
}
