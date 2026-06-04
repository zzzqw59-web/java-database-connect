package exam_database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TreatmentInsertTest {
    static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBConnectionUtil.getConnection("xe", "hr", "hr1234");
            stmt = conn.createStatement();

            String query = """
                    INSERT INTO treatment(t_no, t_course_abbr, t_course, t_tel)
                    VALUES(1004, 'GS', '일반외과', '02-3452-4001')
                    """;
            int insertCount = stmt.executeUpdate(query);

            if (insertCount == 1) {
                System.out.println("레코드 추가 성공");
            } else {
                System.out.println("레코드 추가 실패");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("[드라이버 ERROR] 드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.err.println("[쿼리문 ERROR] \n" + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.err.println("[Close ERROR] \n" + e.getMessage());
        }
        }

    }
}
