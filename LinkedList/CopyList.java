
import java.util.HashMap;

//copy list with random pointers 
public class CopyList{
    class Node{
    int val ;
    Node next;
    Node random;
    Node(int val)
    {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
    public Node copyRandomList2(Node head)
    {
        Node temp = head;
        HashMap<Node,Node> map = new HashMap<>();
        while(temp != null)
        {
            Node newnNode = new Node(temp.val);
            map.put(temp, newnNode);
            temp = temp.next;
        }
        temp = head;
        while(temp != null)
        {
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);

            temp = temp.next; 
        }
        return map.get(head);
    }
    public Node copyRandomList(Node head) {
        Node temp = head;
        while(temp != null)
        {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        temp = head;
        //connect random pointers
        while(temp != null)
        { 
            Node copyNode = temp.next;
            if(temp.random != null)
            {
                copyNode.random = temp.random.next;
            }
            
            temp = temp.next.next;
        }
        //connecting next pointers
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while(temp != null)
        {
            res.next = temp.next;
            temp.next = temp.next.next;

            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}