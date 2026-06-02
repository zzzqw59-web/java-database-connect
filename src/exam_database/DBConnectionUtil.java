package exam_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    public static Connection getConnection(String serviceName, String id, String password) throws ClassNotFoundException, SQLException {
        String url = "jdbc:oracle:thin:@//localhost:1521/" + serviceName;
        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(url, id, password);
    }
}
