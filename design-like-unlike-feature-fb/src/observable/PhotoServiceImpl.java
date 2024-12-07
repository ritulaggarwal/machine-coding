package observable;

import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class PhotoServiceImpl implements PhotoService{

    private String photoId;
    private List<Observer> observerList;

    public PhotoServiceImpl(String photoId) {
        this.photoId = photoId;
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(String userId) {
        for(Observer observer: observerList) {
            observer.update(userId, photoId);
        }
    }

    @Override
    public void likePhoto(String userId) {
        System.out.println("User: " + userId + " likes photo: " + this.photoId);
        notifyObservers(userId);
    }

}
