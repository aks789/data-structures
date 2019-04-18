package queues;

/**
 * Simple circular array implementation for Queue Data Structure
 * Created by aks789 on 12/8/2018.
 */
public class SimpleCircularArrayImpl {

    private int[] queueRep;
    private int front , rear , size;

    private static final int CAPACITY=16;

    public SimpleCircularArrayImpl(){
        queueRep = new int[CAPACITY];
        size=0; front=0;rear=0;
    }

    public SimpleCircularArrayImpl(int cap){
        queueRep = new int[cap];
        size=0;front=0;rear=0;
    }

    /**
     * Time complexity for enQueue O(1)
     * @param data
     */
    public void enQueue(int data){
        if(size==CAPACITY){
            throw new IllegalStateException("Queue overflow exception");
        }else{
            size++;
            queueRep[rear]=data;
            rear=(rear+1) % CAPACITY;
        }
    }

    /**
     * Time complexity for deQueue O(1)
     * @return
     */
    public int deQueue(){
        if(size==0){
            throw new IllegalStateException("Queue is already empty");
        }else{
            size--;
            int data = queueRep[front % CAPACITY];
            front = ( front + 1 ) % CAPACITY;
            return data;
        }
    }


    public int getSize(){
        return size;
    }

    public boolean isFull(){
        return size==CAPACITY;
    }

    public boolean isEmpty(){
        return size==0;
    }

    /**
     * String representation for queue
     * @return
     */
    public String toString(){
        String result = " [ ";
        for(int i=0 ;i < size ; i++){
            result += Integer.toString(queueRep[(front + i) % CAPACITY]);
            if(i<size-1){
                result +=", ";
            }
        }

        result += " ]";
        return result;
    }

    public static void main(String[] args){
        SimpleCircularArrayImpl circArrayQueue = new SimpleCircularArrayImpl();
        circArrayQueue.enQueue(4);
        circArrayQueue.enQueue(3);
        circArrayQueue.enQueue(20);
        circArrayQueue.enQueue(1);

        System.out.println(circArrayQueue.toString());

        circArrayQueue.deQueue();
        circArrayQueue.deQueue();
        circArrayQueue.enQueue(5);

        System.out.println(circArrayQueue.toString());
    }
}
