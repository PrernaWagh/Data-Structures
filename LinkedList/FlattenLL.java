
import java.util.Scanner;

public class FlattenLL {

    public class Node {

        int val;
        Node next;
        Node child;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next, Node child) {
            this.val = val;
            this.next = next;
            this.child = child;
        }
    }


    Node mergerLists(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node res = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }
        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }

        return dummy.child;
    }

    Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mergeHead = flatten(head.next);
        return mergerLists(head, mergeHead);
    }

    
}
