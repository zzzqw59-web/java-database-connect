package exam_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TreatmentInsertTest3 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement pstmt = null;

        String courseAbbr, course, tel;
        int no;

        try {
            System.out.println("진료번호, 진료과목약어, 진료과목(공백없이), 전화번호(-포함)를 순서대로 입력하시오.");
            no = scanner.nextInt();
            courseAbbr = scanner.next();
            course = scanner.next();
            tel = scanner.next();

            conn = DBConnectionUtil.getConnection("xe", "hr", "hr1234");

            String query = """
                    INSERT INTO treatment(t_no, t_course_abbr, t_course, t_tel)
                    Values(?, ?, ?, ?)
                    """;

            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, no);
            pstmt.setString(2, courseAbbr);
            pstmt.setString(3, course);
            pstmt.setString(4, tel);

            int intCount = pstmt.executeUpdate();

            if (intCount == 1) {
                System.out.println("레코드 추가 성공");
            } else {
                System.out.println("레코드 추가 실패");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("[드라이버 ERROR] 드라이버를 찾을 수 없습니다.");
        } catch (InputMismatchException i) {
            System.err.println("[데이터 입력 ERROR] \n" + i.getMessage());
        } catch (SQLException e) {
            System.err.println("[쿼리문 ERROR] \n" + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (scanner != null) {
                    scanner.close();
                }
            } catch (Exception e) {
                System.out.println("[Close ERROR] \n" + e.getMessage());
            }
        }
    }
}
