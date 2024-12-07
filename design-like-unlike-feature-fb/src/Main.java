import observable.PhotoService;
import observable.PhotoServiceImpl;
import observer.Observer;
import observer.User;

public class Main {
    public static void main(String[] args) {
        PhotoService photoService = new PhotoServiceImpl("pic_123");
        Observer user1 = new User("user-1");
        Observer user2 = new User("user-23");

        photoService.addObserver(user1);
        photoService.addObserver(user2);

        photoService.likePhoto("Ritul");
    }
}