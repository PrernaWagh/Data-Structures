/*Problem statement:   
Given the head of a singly linked list, group all the nodes with odd indices together 
followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
*/
class Listnode {
     int val;
     Listnode next;
     Listnode() {}
     Listnode(int val) { this.val = val; }
    Listnode(int val, Listnode next) { this.val = val; this.next = next; }
 }
public class OddEvenLL {
    public Listnode oddEvenList(Listnode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        Listnode odd = head;
        Listnode even = head.next;
        Listnode evenHead = even;
        while(even != null && even.next != null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}