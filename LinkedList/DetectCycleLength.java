//detect a cycle or loop in linked list
import java.util.HashMap;
public class DetectCycleLength {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public int lenOfCycle(ListNode head)
    {
        ListNode temp = head;
        HashMap<ListNode,Integer> map = new HashMap<>();
        int t=1;
        while(temp != null)
        {
            if(map.containsKey(temp))
            {
                int val = map.get(temp);
                return t-val;
            }
            map.put(temp,t);
            t++;
            temp = temp.next;
        }
        return 0;
    }
    public int hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return findLength(slow,fast);
            }
        }
        return 0;
    }
    int findLength(ListNode slow,ListNode fast){  //returns length of cycle
        int cnt = 1;
        fast = fast.next;
        while(fast != slow)
        {
            cnt++;
        }
        return cnt;
    }


}
