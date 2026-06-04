//package exam_database;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class EmployeeSelectTest2 {
//    static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//
//        try {
//            conn = DBConnectionUtil.getConnection("xe", "hr", "hr1234");
//            stmt = conn.createStatement();
//
//            String query = """
//                    SELECT employee_id, first_name, salary, department_name
//                    FROM employees e JOIN departments d
//                    ON e.department_id = d.department_id
//                    """;
//
//            int insertCount = stmt.executeUpdate(query);
//
//            if (insertCount == 1) {
//                System.out.println("데이터 출력 성공");
//            } else {
//                System.out.println("데이터 출력 실패");
//            }
//        }
//
//    }
//}
