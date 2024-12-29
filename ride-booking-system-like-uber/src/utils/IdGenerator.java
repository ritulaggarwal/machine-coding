package utils;

public class IdGenerator {

    private static int id = 0;

    public static String getNextId() {
        synchronized (IdGenerator.class) {
            id+=1;
            return String.valueOf(id);
        }
    }

}
