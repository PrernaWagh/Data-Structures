
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Queue<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front = null;
    Node rear = null;

    void enqueue(T data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    T dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!!!");
        }

        T ele = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return ele;
    }

    T queueFront() {
        if (front == null) {
            System.out.println("Queue is empty!!!");
            return null;
        }
        return front.data;
    }

    T queueRear() {
        if (rear == null) {
            System.out.println("Queue is empty!!!");
            return null;
        }
        return rear.data;
    }

    public static void main(String s[]) {
        Queue<Integer> q = new Queue<>();
        try (Scanner sc = new Scanner(System.in)) {
            int ch;
            try {
                do {
                    System.out.println("\n---- Queue Menu ----");
                    System.out.println("1. Enqueue");
                    System.out.println("2. Dequeue");
                    System.out.println("3. Front");
                    System.out.println("4. Rear");
                    System.out.println("5. Exit");
                    System.out.print("Enter choice: ");

                    ch = sc.nextInt();

                    switch (ch) {
                        case 1 -> {
                            System.out.print("Enter data: ");
                            int data = sc.nextInt();
                            q.enqueue(data);
                        }

                        case 2 -> {
                            int d = q.dequeue();
                            if (d != -1)
                                System.out.println("Dequeued: " + d);
                        }

                        case 3 -> {
                            int f = q.queueFront();
                            if (f != -1)
                                System.out.println("Front: " + f);
                        }

                        case 4 -> {
                            int r = q.queueRear();
                            if (r != -1)
                                System.out.println("Rear: " + r);
                        }

                        case 5 -> System.out.println("Exiting...");

                        default -> System.out.println("Invalid choice!");
                    }

                } while (ch != 5);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
