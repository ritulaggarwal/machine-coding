package observable;

import observer.NotificationObserver;

public interface StockObservable {

    void addObserver(NotificationObserver notificationObserver);
    void removeObserver(NotificationObserver notificationObserver);
    void notifyObservers();
    void setStockCount(int newStockCount);
    int getStockCount();
}
