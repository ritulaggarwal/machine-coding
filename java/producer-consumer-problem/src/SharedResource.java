import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize) {
        this.bufferSize = bufferSize;
        sharedBuffer = new LinkedList<>();
    }

    public synchronized void produce(int item) throws Exception {
        // using while instead of 'if' to avoid spurious thread wake up due to system noise.
        while(sharedBuffer.size() >= bufferSize) {
            System.out.println("Buffer is full, producer is waiting for consumer");
            wait();
        }
        sharedBuffer.offer(item);
        System.out.println("Produced item: " + item);
        notify();
    }

    public synchronized int consume() throws Exception {
        while(sharedBuffer.isEmpty()) {
            System.out.println("Buffer is empty, Consumer is waiting for producer to produce.");
            wait();
        }
        int item = sharedBuffer.poll();
        System.out.println("Consumed item: "+ item);
        notify();
        return item;
    }

}
