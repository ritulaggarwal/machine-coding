public class ConsumerRunnable implements Runnable {

    private SharedResource sharedResource;

    public ConsumerRunnable(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<=6;i++) {
                sharedResource.consume();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
