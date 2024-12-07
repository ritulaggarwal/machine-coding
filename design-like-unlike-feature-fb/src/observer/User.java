package observer;

import observable.PhotoService;

public class User implements Observer {
    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    @Override
    public void update(String userName, String photoId) {
        System.out.println("Notification to User " + this.userId + ": " + userName + " liked the photo " + photoId);

    }
}
