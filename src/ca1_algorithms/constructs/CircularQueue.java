package ca1_algorithms.constructs;

/**
 * Custom Circular Queue Implementation.
 * Models storing up to 8 food trays (FIFO: Enqueue at front, Dequeue at opposite side).
 * Implements StorageInterface for Abstraction and Polymorphism.
 * 
 * @author Gabriel, Dylan
 */
public class CircularQueue implements StorageInterface {
    private FoodTray[] queue;
    private int front, rear, size;

    public CircularQueue(int size) {
        if (size <= 0) {
            System.out.println("⚠ Invalid capacity provided! Setting default size to 8.");
            size = 8;
        }
        this.size = size;
        this.queue = new FoodTray[size];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * Checks if the queue is empty.
     * Time Complexity: O(1) - Constant time check on pointer state.
     */
    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    /**
     * Checks if the queue has reached max capacity using modular arithmetic.
     * Time Complexity: O(1) - Constant time arithmetic calculation.
     */
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    /**
     * Inserts a food tray at the front side of the storage unit.
     * Error Handling: Prevents NullPointerException when inserting null items.
     * Time Complexity: O(1) - Constant time insertion using index pointers.
     */
    public void enqueue(FoodTray item) {
        if (item == null) {
            System.out.println("⚠ Error: Cannot add a null item to the queue!");
            return;
        }

        if (isFull()) {
            System.out.println("⚠ Queue is full! Cannot add more trays (Max capacity: " + size + ").");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % size;
        queue[rear] = item;
        System.out.println("✔ " + item.getName() + " added to the queue.");
    }

    /**
     * Removes a food tray from the opposite side of the storage unit.
     * Error Handling: Prevents Underflow errors when queue is empty and clears dereferenced slots.
     * Time Complexity: O(1) - Constant time removal without array shifts.
     */
    public FoodTray dequeue() {
        if (isEmpty()) {
            System.out.println("⚠ Queue is empty! No items to remove.");
            return null;
        }

        FoodTray item = queue[front];
        queue[front] = null; // Garbage collector cleanup

        if (front == rear) { // Only one item was in the queue
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        System.out.println("✔ " + item.getName() + " removed from the queue.");
        return item;
    }

    /**
     * Displays the food item present at the front of the queue.
     * Time Complexity: O(1) - Direct array lookup via front pointer.
     */
    @Override
    public void peek() {
        if (isEmpty()) {
            System.out.println("⚠ Queue is empty! No item to display.");
            return;
        }
        System.out.println("Front of the queue: " + queue[front].getName() + " (" + queue[front] + ")");
    }

    /**
     * Displays all items currently present in the queue.
     * Error Handling: Safe iteration based on exact item count.
     * Time Complexity: O(n) - Iterates through n elements currently stored.
     */
    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("⚠ Queue is empty!");
            return;
        }

        System.out.println("--- Queue Contents ---");
        int count = getCount();
        int current = front;

        for (int i = 0; i < count; i++) {
            System.out.println("Position " + (i + 1) + ": " + queue[current]);
            current = (current + 1) % size;
        }
    }

    /**
     * Calculates current number of elements in the queue.
     * Time Complexity: O(1) - Mathematical computation.
     */
    public void size() {
        int currentSize = getCount();
        System.out.println("Queue size: " + currentSize + " / " + size);
    }

    /**
     * Helper method to compute exact item count safely.
     * Time Complexity: O(1)
     */
    private int getCount() {
        if (isEmpty()) {
            return 0;
        }
        if (rear >= front) {
            return rear - front + 1;
        }
        return size - front + rear + 1;
    }

    /**
     * Performs a linear search for a food item by name.
     * Error Handling: Validates null/empty search strings and handles null elements safely.
     * Time Complexity: O(n) - Traverses elements sequentially until match/end.
     */
    @Override
    public void search(String name) {
        if (isEmpty()) {
            System.out.println("⚠ Queue is empty! Search cancelled.");
            return;
        }

        if (name == null || name.trim().isEmpty()) {
            System.out.println("⚠ Invalid search input! Please enter a valid food name.");
            return;
        }

        String searchName = name.trim();
        boolean found = false;
        int count = getCount();
        int current = front;

        for (int i = 0; i < count; i++) {
            if (queue[current] != null && queue[current].getName().equalsIgnoreCase(searchName)) {
                System.out.println("✔ Found at position " + (i + 1) + ": " + queue[current]);
                found = true;
            }
            current = (current + 1) % size;
        }

        if (!found) {
            System.out.println("❌ Food item not found: " + searchName);
        }
    }
}
