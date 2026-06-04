package book;

import exam_database.DBConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class EmployeesCheckMain {
    static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        String firstName;
        String commisionPct;
        String departmentName;

        String query = """
                SELECT e.first_name, e.commission_pct, department_name
                FROM employees e JOIN departments d
                ON e.department_id = d.department_id
                WHERE commission_pct >= 0
                """;

        try {
            conn = DBConnectionUtil.getConnection("XE", "hr", "hr1234");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("----- 메세지 출력 -----");

            while (rs.next()) {
                firstName = rs.getString("first_name");
                commisionPct = rs.getString("commission_pct");
                departmentName = rs.getString("department_name");

                System.out.println(firstName + "   " + commisionPct + "   " + departmentName);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 에러");
        } catch (SQLException e) {
            System.out.println("쿼리문 에러: " + e.getMessage());
        } finally {
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
