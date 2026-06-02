package exam_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    static void main(String[] args) {
        // 형식: jdbc:oracle:thin:@//호스트명:포트번호/서비스이름
        String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("드라이버 적재 성공");

            conn = DriverManager.getConnection(url, "javauser", "java1234");
            System.out.println("데이터 베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
            // e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("연결에 실패했습니다.");
            // e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("자원 해제에 실패했습니다.");
            }
        }
    }
}
