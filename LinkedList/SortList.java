public class SortList {
    class ListNode {

        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = mid.next;
        mid.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeList(leftHead,rightHead);
    }
    public ListNode mergeList(ListNode list1,ListNode list2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(list1 != null && list2 != null)
        {
            if(list1.data < list2.data)
            {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
               
            }
            else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        temp.next = (list1 != null)? list1:list2;
        return dummy.next;
    }
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
