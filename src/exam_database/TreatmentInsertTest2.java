package exam_database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TreatmentInsertTest2 {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;

        String courseAbbr, course, tel;
        int no;

        try {
            System.out.println("진료과목, 진료과목약어, 진료과목(공백 없이), 전화번호(- 포함하여) 순서대로 입력해주세요.");
            no = input.nextInt();
            courseAbbr = input.next();
            course = input.next();
            tel = input.next();

            conn = DBConnectionUtil.getConnection("xe", "hr", "hr1234");
            stmt = conn.createStatement();

            String query = """
                    INSERT INTO treatment(t_no, t_course_abbr, t_course, t_tel)
                    VALUES(%d, '%s', '%s', '%S')
                    """.formatted(no, courseAbbr, course, tel);

            int insertCount = stmt.executeUpdate(query);

            if (insertCount == 1) {
                System.out.println("레코드 추가 성공");
            } else {
                System.out.println("레코드 추가 실패");
            }
        } catch (InputMismatchException i) {
            System.err.println("[데이터 입력 ERROR] \n" + i.getMessage());
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
                if (input != null) {
                    input.close();
                }
            } catch (Exception e) {
                System.err.println("[Close ERROR] \n" + e.getMessage());
            }
        }
    }
}
