
import java.util.PriorityQueue;

public class MergeKLists{

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode mergeKLists(ListNode[] lists)  
    {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i=0;i<lists.length;i++)
        {
            if(lists[i] !=null)
            {
                pq.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(!pq.isEmpty())
        {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if(node.next != null)
            {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}