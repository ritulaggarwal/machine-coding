package observable;

import observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {
    private List<NotificationObserver> observerList;
    int stockCount = 0 ;

    public IphoneObservableImpl() {
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(NotificationObserver notificationObserver) {
        observerList.add(notificationObserver);
    }

    @Override
    public void removeObserver(NotificationObserver notificationObserver) {
        observerList.remove(notificationObserver);
    }

    @Override
    public void notifyObservers() {
        for(NotificationObserver observer: observerList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockCount) {
        if(stockCount == 0) {
            this.stockCount += newStockCount;
            notifyObservers();
            return;
        }
        this.stockCount += newStockCount;
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
