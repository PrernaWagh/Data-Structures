public class RotateList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

   ListNode findNthNode(ListNode head,int k)
    {
        int cnt = 1;
        ListNode temp = head;
        while(temp != null )
        {
            if(cnt == k) return temp;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode temp = head;
        int len = 1;
        while(temp.next != null)
        {
            temp = temp.next;
            len++;
        }
        if(k % len == 0) return head;
        k = k % len;
        temp.next = head;
        ListNode lastNode = findNthNode(head,len -k);
        head = lastNode.next;
        lastNode.next = null;

        return head;
    }
}
