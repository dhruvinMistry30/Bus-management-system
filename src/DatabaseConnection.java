import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/bus_travel";
    private static final String username = "root"; // replace the username of your mysql 
    private static final String password = ""; // insert the password of your mysql

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
