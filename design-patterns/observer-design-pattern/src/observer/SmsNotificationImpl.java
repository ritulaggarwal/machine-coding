package observer;

import observable.StockObservable;

public class SmsNotificationImpl implements NotificationObserver {
    private final StockObservable stockObservable;

    public SmsNotificationImpl(StockObservable stockObservable) {
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("SMS Notification");
        System.out.println("New Stock Available: " + stockObservable.getStockCount());
    }
}
