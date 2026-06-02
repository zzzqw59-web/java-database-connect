package exam_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase2 {
    static void main(String[] args) {
        // 형식: jdbc:oracle:thin:@//호스트명:포트번호/서비스이름
        String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        String user = "javauser";
        String password = "java1234";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("드라이버 적재 성공");

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("데이터베이스 연결 성공");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패했습니다.");
        }
    }
}
