import observable.IphoneObservableImpl;
import observable.StockObservable;
import observer.EmailNotificationImpl;
import observer.NotificationObserver;
import observer.SmsNotificationImpl;

public class Main {
    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new IphoneObservableImpl();
        NotificationObserver emailNotification = new EmailNotificationImpl(iphoneStockObservable);
        NotificationObserver smsNotification = new SmsNotificationImpl(iphoneStockObservable);

        iphoneStockObservable.addObserver(emailNotification);
        iphoneStockObservable.addObserver(smsNotification);

        iphoneStockObservable.setStockCount(10);
        iphoneStockObservable.setStockCount(20);
        iphoneStockObservable.setStockCount(-30);
        iphoneStockObservable.setStockCount(20);

    }
}