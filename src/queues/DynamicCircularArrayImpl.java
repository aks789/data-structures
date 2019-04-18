package queues;

/**
 * Dynamically expanding queue implementation.
 * Capacity of queue doubles once the queue is full
 *
 * Created by aks789 on 12/9/2018.
 */
public class DynamicCircularArrayImpl {

    private static int[] queueRep;
    private static int rear , front , size;
    private static int capacity =4;

    public DynamicCircularArrayImpl(){
        queueRep = new int[capacity];
        int size =0 , rear =0 , front =0;
    }

    public void enQueue(int data){
        if(size==capacity)
            expand();
        size++;
        queueRep[rear] = data;
        rear = (rear + 1) % capacity;
    }

    public int deQueue(){
        if(size==0){
            throw new IllegalStateException("Queue underflow");
        }else{
            size--;
            int data = queueRep[front % capacity ];
            front = ( front+1 ) % capacity;
            return data;
        }
    }

    public int size(){
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    public void expand(){
        int length = size();
        int[] newQueue = new int[length<<1];

        for(int i=front;i<front + size;i++){
            newQueue[i-front] = queueRep[ i % capacity];
        }
        queueRep = newQueue;
        front =0;
        rear = size;
        capacity = capacity*2;
    }



    public String toString(){
        String result = " [ ";

        for(int i=0;i<size;i++){
            result += Integer.toString(queueRep[(front + i) % capacity]);
            if(i<size-1){
                result +=", ";
            }
        }

        return result += " ]";
    }

    public static void main(String[] args){
        DynamicCircularArrayImpl dyncArrayQueueImpl = new DynamicCircularArrayImpl();
        dyncArrayQueueImpl.enQueue(4);
        dyncArrayQueueImpl.enQueue(3);
        dyncArrayQueueImpl.enQueue(20);
        dyncArrayQueueImpl.enQueue(1);

        printResults(dyncArrayQueueImpl);

        dyncArrayQueueImpl.enQueue(5);

        printResults(dyncArrayQueueImpl);

        dyncArrayQueueImpl.enQueue(7);
        dyncArrayQueueImpl.enQueue(8);
        dyncArrayQueueImpl.enQueue(9);

        printResults(dyncArrayQueueImpl);

        dyncArrayQueueImpl.enQueue(10);

        printResults(dyncArrayQueueImpl);


    }

    private static void printResults(DynamicCircularArrayImpl queue){
        System.out.println("QUEUE : " + queue.toString());
        System.out.println("SIZE : " + queue.size());
        System.out.println("CAPACITY :" + queue.getCapacity());
        System.out.println();

    }

}
