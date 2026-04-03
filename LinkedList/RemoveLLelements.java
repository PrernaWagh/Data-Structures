
public class RemoveLLelements {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode p = dummy;
        // while(p.next != null)
        // {
        //     if(p.next.val == val)
        //     {
        //         ListNode temp = p.next;
        //         p.next = temp.next;
        //     }
        //     else{
        //         p = p.next;
        //     }
        // }
        // return dummy.next;
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);

        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
