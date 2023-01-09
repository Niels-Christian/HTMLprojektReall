import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static Connection connection;
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:mysql://mysql-db.caprover.diplomportal.dk/s215846?" +
                        "user=s215846&password=E2yMFR0C4Cs7u3Bc5gsih");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
