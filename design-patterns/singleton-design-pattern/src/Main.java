public class Main {
    public static void main(String[] args) {
        DbConnection dbConnection = DbConnection.getInstance();
        System.out.println(dbConnection.getClass());
    }
}