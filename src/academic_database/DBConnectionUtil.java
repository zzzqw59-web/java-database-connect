package academic_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    // 데이터 베이스 연결 정보
    private static final String JDBC_URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static final String USER = "javauser";
    private static final String PASSWD = "java1234";

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver를 찾을 수 없습니다.");
            e.printStackTrace();
        }
    }

    private DBConnectionUtil(){

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWD);
    }
}
