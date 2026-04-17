public class QueueArray {
    int queue[] = new int[10];
    int front = -1;
    int rear = -1;
    boolean isEmpty(int queue[])
    {
        return front == -1;
    }
    boolean isFull(int queue[])
    {
        return rear == queue.length -1;
    }
    void enqueue()
    {
        if(isFull(queue))
        {
            System.out.println("Queue overflow!!!");
            return;
        }
        
    }
    void dequeue()
    {

    }
    public static void main(String[] args) {
        

    }
}
