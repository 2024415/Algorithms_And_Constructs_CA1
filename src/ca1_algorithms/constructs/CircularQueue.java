package ca1_algorithms.constructs;

/**
 * Custom Circular Queue Implementation.
 * Models storing up to 8 food trays (FIFO: Enqueue at front, Dequeue at opposite side).
 * Implements StorageInterface for Abstraction and Polymorphism.
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
     * Time Complexity: O(1) - Constant time insertion using index pointers.
     */
    public void enqueue(FoodTray item) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add more trays (Max capacity: " + size + ").");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            queue[rear] = item;
            System.out.println(item.getName() + " added to the queue.");
        }
    }

    /**
     * Removes a food tray from the opposite side of the storage unit.
     * Time Complexity: O(1) - Constant time removal without array shifts.
     */
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No items to remove.");
        } else {
            FoodTray item = queue[front];
            if (front == rear) { // Only one item was in the queue
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            System.out.println(item + " removed from the queue.");
        }
    }

    /**
     * Displays the food item present at the front of the queue.
     * Time Complexity: O(1) - Direct array lookup via front pointer.
     */
    @Override
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Front of the queue: " + queue[front].getName() + " (" + queue[front] + ")");
        }
    }

    /**
     * Displays all items currently present in the queue.
     * Time Complexity: O(n) - Iterates through n elements currently stored.
     */
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
            System.out.println(queue[rear]); // Print rear element
        }
    }

    /**
     * Calculates current number of elements in the queue.
     * Time Complexity: O(1) - Mathematical computation.
     */
    public void size() {
        if (isEmpty()) {
            System.out.println("Queue size: 0");
        } else if (rear >= front) {
            System.out.println("Queue size: " + (rear - front + 1));
        } else {
            System.out.println("Queue size: " + (size - front + rear + 1));
        }
    }

    /**
     * Performs a linear search for a food item by name.
     * Time Complexity: O(n) - Traverses elements sequentially until match/end.
     */
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
