package algorithms_and_constructs_ca1;

public class CircularQueue implements StorageInterface {
    private FoodTray[] queue;
    private int front, rear, size;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new FoodTray[size];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

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

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No items to remove.");
        } else {
            FoodTray item = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            System.out.println(item + " removed from the queue.");
        }
    }

    @Override
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Front of the queue: " + queue[front].getName() + " (" + queue[front] + ")");
        }
    }

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
            System.out.println(queue[rear]);
        }
    }

    public void size() {
        if (isEmpty()) {
            System.out.println("Queue size: 0");
        } else {
            int currentSize = (rear - front + 1 + size) % size;
            if (currentSize == 0) currentSize = size;
            System.out.println("Queue size: " + currentSize);
        }
    }

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
