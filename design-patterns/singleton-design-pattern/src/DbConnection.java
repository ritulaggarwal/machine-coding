public class DbConnection {

    private static DbConnection dbConnection;

    private DbConnection(){

    }

    public static DbConnection getInstance() {
        if(dbConnection == null) {
            synchronized (DbConnection.class) {
                if(dbConnection == null) {
                    dbConnection = new DbConnection();
                }
            }
        }
        return dbConnection;
    }
}
