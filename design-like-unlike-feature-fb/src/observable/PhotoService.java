package observable;

import observer.Observer;

public interface PhotoService {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String userId);
    void likePhoto(String userId);

}
