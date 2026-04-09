//remove duplicates from sorted doubly linked list 

public class RemoveDuplicates{
    class ListNode{
        int data;
        ListNode next;
        ListNode prev;
        public ListNode()
        {
            data = 0;
            next = null;
            prev = null;
        }
        public ListNode(int data,ListNode next,ListNode prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    public ListNode removeDuplicates(ListNode head)
    {
        ListNode temp = head;
        while(temp != null && temp.next != null)
        {
            ListNode nextNode = temp.next;
            while(nextNode != null && nextNode.data == temp.data)
            {
                nextNode = nextNode.next;
            }

            temp.next = nextNode;
            if(nextNode != null)
            {
                nextNode.prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}