public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);

        // Creating producer thread using lambda expression
        Thread producerThread = new Thread(()-> {
           try{
               for(int i=0;i<=6;i++) {
                   sharedResource.produce(i);
               }
           } catch (Exception exception) {

           }
        });

        // Creating consumer thread by implementing Runnable interface in separate class
        ConsumerRunnable consumerRunnable = new ConsumerRunnable(sharedResource);
        Thread consumerThread = new Thread(consumerRunnable);

        producerThread.start();
        consumerThread.start();

    }
}