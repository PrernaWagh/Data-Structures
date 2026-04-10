// You are given two non-empty linked lists representing two non-negative integers. 
//The digits are stored in reverse order, and each of their nodes contains a single digit. 
// Add the two numbers and return the sum as a linked list.

import java.util.Scanner;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data)
    {
        this.data = data;
        this.next = null;
    }
}
public class AddListElements_1 {
    Scanner sc = new Scanner(System.in);
    static ListNode addElements(ListNode head1,ListNode head2)
    {
        ListNode t1 = head1;
        ListNode t2 = head2;
        int carry = 0;
        int sum = 0;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(t1 != null || t2 != null)
        {
            sum = carry;
            if(t1 != null) sum = sum + t1.data;
            if(t2 != null) sum = sum + t2.data;

            ListNode newListNode = new ListNode(sum % 10);
            carry = sum/10;

            current.next = newListNode;
            current = current.next;

            if(t1 != null) t1 = t1.next;
            if(t2 != null) t2 = t2.next;
        }
        if(carry == 1)
        {
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }
        return dummy.next;
    }
    ListNode createLinkedList() {
        int data;
        String ch;
        System.out.println("Enter data for new node : ");
        data = sc.nextInt();
        ListNode head = new ListNode(data);
        ListNode p = head;
        do {
            System.out.println("Do you want to add more nodes : ");
            ch = sc.next();
            if (ch.equalsIgnoreCase("y")) {
                System.out.println("Enter data for node : ");
                data = sc.nextInt();
                ListNode newNode = new ListNode(data);
                p.next = newNode;
                p = p.next;
            } else {
                break;
            }
        } while (true);
        return head;
    }
    static void displayList(ListNode head) {
        ListNode p = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println("");
    }

    public static void main(String s[])
    {
        AddListElements_1 obj1 = new AddListElements_1();
        AddListElements_1 obj2 = new AddListElements_1();
        ListNode head1 = obj1.createLinkedList();
        ListNode head2 = obj2.createLinkedList();
        displayList(head1);
        displayList(head2);
        ListNode head3 = addElements(head1, head2);
        displayList(head3);
    }
}
