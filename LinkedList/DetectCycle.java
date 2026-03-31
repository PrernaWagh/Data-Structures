import java.util.HashMap;

public class DetectCycle {
    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle1(ListNode head)
    {
        //brute force
        ListNode temp = head;
        HashMap<ListNode,Integer> map = new HashMap<>();
        int t=1;
        while(temp != null)
        {
            if(map.containsKey(temp))
            {
                return true;
            }
            map.put(temp,t);
            t++;
            temp = temp.next;
        }
        return false;
    }
    public boolean  hasCycle2(ListNode head) {
        //optimal
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
