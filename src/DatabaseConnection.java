import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/bus_travel";
    private static final String username = "root";
    private static final String password = "Passwords@3001";

    public static Connection getConnection() throws SQLException {
        
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
       }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
       }
       return DriverManager.getConnection(url,username,password);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if(connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}