/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg6_files_2;

/**
 *
 * @author Gabriel
 */
public class CircularQueue implements StorageInterface {
    private FoodTray[] queue;
    private int front, rear, size;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new FoodTray[size];
        this.front = -1;
        this.rear = -1;
    }

    // Check if empty - Time Complexity: O(1)
    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if full using modulo arithmetic - Time Complexity: O(1)
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Add tray at Front Side (Enqueue) - Time Complexity: O(1)
    public void enqueue(FoodTray item) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            if (front == -1) { // First element to be enqueued
                front = 0;
            }
            rear = (rear + 1) % size; // Wrap around to the front if needed
            queue[rear] = item;
            System.out.println(item.getName() + " added to the queue.");
        }
    }

    // Remove tray from Opposite Side (Dequeue) - Time Complexity: O(1)
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            FoodTray item = queue[front];
            if (front == rear) { // Only one element left in the queue
                front = rear = -1; // Reset queue
            } else {
                front = (front + 1) % size; // Move front pointer forward
            }
            System.out.println(item + " removed from the queue.");
        }
    }

    // View front tray at Opposite Side (Peek) - Time Complexity: O(1)
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Front of the queue: " + queue[front].getName() + " (" + queue[front] + ")");
        }
    }

    // Display all trays in Queue - Time Complexity: O(n)
    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Queue contents: ");
            int i = front;
            while (i != rear) {
                System.out.println(queue[i]);
                i = (i + 1) % size;
            }
            System.out.println(queue[rear]); // Print the rear element
        }
    }

    // Calculate current size - Time Complexity: O(1)
    public void size() {
        if (isEmpty()) {
            System.out.println("Queue size: 0");
        } else {
            int currentSize = (rear - front + 1 + size) % size;
            if (currentSize == 0) currentSize = size;
            System.out.println("Queue size: " + currentSize);
        }
    }

    // Linear search by food name - Time Complexity: O(n)
    @Override
    public void search(String name) {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        boolean found = false;
        int i = front;
        while (true) {
            if (queue[i].getName().equalsIgnoreCase(name.trim())) {
                System.out.println("Found: " + queue[i]);
                found = true;
            }
            if (i == rear) break;
            i = (i + 1) % size;
        }
        if (!found) {
            System.out.println("Food item not found: " + name);
        }
    }
}
