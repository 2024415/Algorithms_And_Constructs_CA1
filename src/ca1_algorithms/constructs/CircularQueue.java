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
    // front = index of the tray at the removal side, rear = index of the tray most recently added
    private int front, rear, capacity;

    public CircularQueue(int capacity) {
        if (capacity <= 0) {
            System.out.println("Invalid capacity provided! Setting default size to 8.");
            capacity = 8;
        }
        this.capacity = capacity;
        this.queue = new FoodTray[capacity];
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
        return (rear + 1) % capacity == front;
    }

    /**
     * Inserts a food tray at the front side of the storage unit.
     * Error Handling: Prevents NullPointerException when inserting null items.
     * Time Complexity: O(1) - Constant time insertion using index pointers.
     */
    public void enqueue(FoodTray item) {
        if (item == null) {
            System.out.println("Error: Cannot add a null item to the queue!");
            return;
        }

        if (isFull()) {
            System.out.println("Queue is full! Cannot add more trays (Max capacity: " + capacity + ").");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }
        rear = (rear + 1) % capacity; // Wrap around to the front if needed
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
            System.out.println("Queue is empty! No items to remove.");
            return null;
        }

        FoodTray item = queue[front];
        queue[front] = null; // free the slot

        if (front == rear) { // Only one element left in the queue
            front = rear = -1; // Reset queue
        } else {
            front = (front + 1) % capacity; // Move front pointer forward
        }

        System.out.println("✔ " + item.getName() + " removed from the queue.");
        return item;
    }

    /**
     * Displays the food item present at the front of the queue.
     * Time Complexity: O(1) - Direct array lookup via front pointer.
     */
    @Override
    public FoodTray peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No item to display.");
            return null;
        }
        return queue[front];
    }

    /**
     * Displays all items currently present in the queue.
     * Error Handling: Safe iteration based on exact item count.
     * Time Complexity: O(n) - Iterates through n elements currently stored.
     */
    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("--- Queue Contents ---");
        int i = front;
        while (i != rear) {
            System.out.println(queue[i]);
            i = (i + 1) % capacity;
        }
        System.out.println(queue[rear]); // Print the rear element
    }

    /**
     * Calculates current number of elements in the queue.
     * Time Complexity: O(1) - Mathematical computation.
     */
    public void size() {
        if (isEmpty()) {
            System.out.println("Queue size: 0");
        } else {
            int currentSize = (rear - front + 1 + capacity) % capacity;
            if (currentSize == 0) currentSize = capacity;
            System.out.println("Queue size: " + currentSize);
        }
    }

    /**
     * Performs a linear search for a food item by name.
     * Error Handling: Validates null/empty search strings and handles null elements safely.
     * Time Complexity: O(n) - Traverses elements sequentially until match/end.
     */
    @Override
    public void search(String name) {
        if (isEmpty()) {
            System.out.println("Queue is empty! Search cancelled.");
            return;
        }

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid search input! Please enter a valid food name.");
            return;
        }

        String searchName = name.trim();
        boolean found = false;
        int i = front;

        while (true) {
            if (queue[i] != null && queue[i].getName().equalsIgnoreCase(searchName)) {
                System.out.println("✔ Found at position: " + queue[i]);
                found = true;
            }
            if (i == rear) break;
            i = (i + 1) % capacity;
        }

        if (!found) {
            System.out.println("❌ Food item not found: " + searchName);
        }
    }
}
