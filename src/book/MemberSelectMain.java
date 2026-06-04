package book;

import exam_database.DBConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberSelectMain {
    static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        String query = """
                SELECT *
                FROM member
                """;

        try {
            conn = DBConnectionUtil.getConnection("XE", "hr", "hr1234");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int memberId;
            String memberName;
            String birthDate;
            String phoneNumber;
            String address;

            System.out.println("---- Member 데이터 출력 ----");
            System.out.printf("%s\t%s\t%s\t%s\t%s\n",
                    "멤버아이디", "멤버이름", "생일", "연락처", "주소");
            while (rs.next()) {
                memberId = rs.getInt("member_id");
                memberName = rs.getString("member_name");
                birthDate = rs.getString("birth_date");
                phoneNumber = rs.getString("phone_number");
                address = rs.getString("address");

                System.out.printf("%-7d %-11s %-15s %-15s %s\n",
                        memberId, memberName, birthDate, phoneNumber, address);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 오류");
        } catch (SQLException e) {
            System.out.println("데이터 베이스 오류: " + e.getMessage());
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("에러 발생");
            }
        }
    }
}

