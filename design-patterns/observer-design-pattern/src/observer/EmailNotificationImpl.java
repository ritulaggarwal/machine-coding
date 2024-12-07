package observer;

import observable.StockObservable;

public class EmailNotificationImpl implements NotificationObserver {
    private final StockObservable stockObservable;

    public EmailNotificationImpl(StockObservable stockObservable) {
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        System.out.println("Email Notification");
        System.out.println("New Stock Available: " + stockObservable.getStockCount());
    }
}
