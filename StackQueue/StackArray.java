
public class StackArray {

    int st[] = new int[10];
    int top = -1;

    boolean isEmpty(int st[]) {
        return top == -1;
    }
    boolean isFull(int st[])
    {
        return top == st.length-1;
    }
    void push(int st[],int ele)
    {
        //O(1)
        if(isFull(st))
        {
            System.out.println("Stack overflow!!!");
            return;
        }
        top++;
        st[top] = ele;
        System.out.println("Element "+ele+" is pushed");
    }
    int pop(int st[],int ele)
    {
        //O(1)
        if(isEmpty(st))
        {
            System.out.println("Stack underflow!!!");
            return -1;
        }
        int pop_ele = st[top];
        top--;
        return pop_ele; 
    }
    int peek(int st[],int ele)
    {
        //O(1)
        if(isEmpty(st))
        {
            System.out.println("Stack underflow!!!");
            return -1;
        }
        return st[top]; 
    }

    
    public static void main(String[] args) {

    }
}
