import java.util.InputMismatchException;
import java.util.Scanner;

public class StackLinkedList<T> {
    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;

    boolean isEmpty() {
        return top == null;
    }

    void push(T data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!!!");
            return null;
        }

        T value = top.data;
        top = top.next;
        return value;
    }

    T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!!!");
            return null;
        }

        return top.data;
    }

    public static void main(String[] args) {

        StackLinkedList<Integer> st = new StackLinkedList<>();
        try (Scanner sc = new Scanner(System.in)) {
            int ch;
            try {
                do {
                    System.out.println("\n----Stack Menu----");
                    System.out.println("1. Push");
                    System.out.println("2. Pop");
                    System.out.println("3. Peek");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");

                    ch = sc.nextInt();

                    switch (ch) {
                        case 1 -> {
                            System.out.print("Enter data: ");
                            int data = sc.nextInt();
                            st.push(data);
                        }

                        case 2 -> {
                            Integer ele1 = st.pop();
                            if (ele1 != null)
                                System.out.println("Popped: " + ele1);
                        }

                        case 3 -> {
                            Integer ele2 = st.peek();
                            if (ele2 != null)
                                System.out.println("Top: " + ele2);
                        }

                        case 4 -> System.out.println("Exiting...");

                        default -> System.out.println("Invalid choice!");
                    }

                } while (ch != 4);

            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
            }

        }
    }
}