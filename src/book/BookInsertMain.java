package book;

import exam_database.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookInsertMain {
    static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner input = new Scanner(System.in);

        String title, author, publisher, publisherDate;
        int price;

        try {
            System.out.println("책제목, 저자, 출판사, 출간일, 가격을 순서대로 입력하시오.");
            conn = DBConnectionUtil.getConnection("xepdb1", "javauser", "java1234");
            title = input.next();
            author = input.next();
            publisher = input.next();
            publisherDate = input.next();
            price = input.nextInt();

            String query = """
                    INSERT INTO book(title, author, publisher, publish_date, price)
                    VALUES(?, ?, ?, ?, ?)
                    """;

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, publisher);
            pstmt.setString(4, publisherDate);
            pstmt.setInt(5, price);

            int intCount = pstmt.executeUpdate();

            if (intCount == 1) {
                System.out.println("레코드 추가 성공");
            } else {
                System.out.println("레코드 추가 실패");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("레코드를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.err.println("쿼리문 에러: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("데이터 입력 에러: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (input != null) {
                    input.close();
                }
            } catch (Exception e) {
                System.out.println("Close 오류");
            }
        }
    }
}
