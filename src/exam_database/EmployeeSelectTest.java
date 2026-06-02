package exam_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeSelectTest {
    static void main(String[] args) {
        int employeeId;
        int salary;
        String firstName;
        String hireDate;

        String sql = """
                SELECT employee_id, first_name, salary, TO_CHAR(hire_date, 'YYYY-MM-DD') AS hire_date
                FROM employees
                """;

        try (
                Connection conn = DBConnectionUtil.getConnection("XE", "hr", "hr1234");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            System.out.println("**** EMPLOYEE 테이블 사원 출력 ****");
            System.out.printf("%s\t%s\t%6s\t%8s\n", "사원번호", "사원이름", "급여", "입사일");
            while (rs.next()) {
                employeeId = rs.getInt("employee_id");
                firstName = rs.getString("first_name");
                salary = rs.getInt("salary");
                hireDate = rs.getString("hire_date");

                System.out.printf("%-7d %-11s %-6d %s\n", employeeId, firstName, salary, hireDate);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("[드라이버 ERROR] 드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("[DB ERROR] 데이터베이스 작업중 오류가 발생했습니다.");
            System.out.println(e.getMessage());
        }
    }
}
