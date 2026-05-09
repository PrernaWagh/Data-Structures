import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Tree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int index = -1;

    // Build Tree from preorder with -1 as NULL
    public static Node buildTree(int preorder[]) {
        index++;
        if (preorder[index] == -1) {
            return null;
        }

        Node root = new Node(preorder[index]);
        root.left = buildTree(preorder);
        root.right = buildTree(preorder);

        return root;
    }

    // Traversals
    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static void preorderPrint(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderPrint(root.left);
            preorderPrint(root.right);
        }
    }

    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }

    // iterative traversals
    static void preorderNonRecursive(Node root) {
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.print(curr.data + " ");

            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
        }

    }

    static void inorderNonRecursive(Node root) {
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while (true) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                curr = st.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }
    }

    static void postOrderNonRecursive(Node root) {
        if (root == null)
            return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);

        while (!st1.isEmpty()) {
            Node curr = st1.pop();
            st2.push(curr);

            if (curr.left != null)
                st1.push(curr.left);
            if (curr.right != null)
                st1.push(curr.right);
        }

        while (!st2.isEmpty()) {
            System.out.print(st2.pop().data + " ");
        }
        System.out.println();
    }
    static void postOrderNonRecursive2(Node root)
    {
        //using one stack
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr != null || !st.isEmpty())
        {
            if(curr != null) 
            {
                 st.push(curr);
                 curr = curr.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp == null) 
                {
                    temp = st.peek();
                    st.pop();
                    System.out.print(temp.data+" ");
                    while(!st.isEmpty() && temp == st.peek().right)
                    {
                        temp = st.peek();
                        st.pop();
                        System.out.print(temp.data+" ");
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int preorder[] = { 1, 2, 4,-1,-1,5,-1,-1, 3, 6,-1, 7, -1, 8,-1,-1,-1};
        Node root = buildTree(preorder);

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Inorder Traversal");
            System.out.println("2. Preorder Traversal");
            System.out.println("3. Postorder Traversal");
            System.out.println("4. Level order traversal");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Inorder: ");
                    // inorder(root);
                    inorderNonRecursive(root);
                    System.out.println();
                    break;

                case 2:
                    System.out.print("Preorder: ");
                    // preorderPrint(root);
                    preorderNonRecursive(root);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Postorder: ");
                     //postorder(root);
                    postOrderNonRecursive2(root);
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Level order : ");
                    levelOrder(root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}