//find the starting node in a loop or cycle of linked list 
import java.util.HashMap;


public class StartNodeInLLCycle {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head)
    {
        //brute force
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode temp = head;
        while(temp != null)  
        {
            if(map.containsKey(temp))
            {
                return temp;
            }
            map.put(temp,1);
        }
        return null;
    }


}
