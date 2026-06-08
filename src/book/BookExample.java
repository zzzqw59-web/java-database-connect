package book;

import exam_database.DBConnectionUtil;

import java.sql.*;
import java.util.Scanner;

public class BookExample {
    private static Scanner scanner = new Scanner(System.in);

    // 데이터 베이스 접근시 필요한 데이터
    private static final String serviceName = "XEPDB1";
    private static final String user = "javauser";
    private static final String password = "java1234";

    public static void showMenu() {
        String menu = """
                선택하세요.
                1. 데이터 입력
                2. 데이터 조회
                3. 데이터 삭제
                4. 프로그램 종료
                """;
        System.out.println(menu);
        System.out.print("선택: ");
    }

    public static int inputMenu() {
        showMenu();
        return Integer.parseInt(scanner.nextLine());
    }

    public static void addBlock() throws ClassNotFoundException, SQLException, IllegalArgumentException {
        int price;
        String title, author, publisher;
        Date publishDate;

        System.out.println("[도서 정보 입력]");
        System.out.print("책이름 입력: ");
        title = scanner.nextLine();

        System.out.print("저자 입력: ");
        author = scanner.nextLine();

        System.out.print("출판사 입력: ");
        publisher = scanner.nextLine();

        if (title.isBlank() || author.isBlank() || publisher.isBlank()) {
            System.out.println("[입력 ERROR] 책 이름, 저자, 출판사는 반드시 입력해야 합니다.");
            return;
        }

        System.out.print("출간일 입력(YYYY-MM-DD): ");
        publishDate = Date.valueOf(scanner.nextLine());

        System.out.print("가격 입력: ");
        price = Integer.parseInt(scanner.nextLine());

        String sql = """
                INSERT INTO BOOK(title, author, publisher, publish_date, price)
                VALUES(?, ?, ?, ?, ?)
                """;

        try (
                Connection conn = DBConnectionUtil.getConnection(serviceName, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, publisher);
            pstmt.setDate(4, publishDate);
            pstmt.setInt(5, price);

            int insertCount = pstmt.executeUpdate();

            System.out.println(insertCount == 1 ? "레코드 추가 성공" : "레코드 추가 실패");
            System.out.println();
        }
    }

    public static void readBook() throws ClassNotFoundException, SQLException {
        String sql = """
                SELECT book_id, title, author, publisher, TO_CHAR(publish_date, 'YYYY-MM-DD') AS publish_date, price
                FROM book
                ORDER BY book_id
                """;

        try (Connection conn = DBConnectionUtil.getConnection(serviceName, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                System.out.println("-".repeat(50));
                System.out.println("책 번호   : " + rs.getInt("book_id"));
                System.out.println("제목    : " + rs.getString("title"));
                System.out.println("저자    : " + rs.getString("author"));
                System.out.println("출판사    : " + rs.getString("publisher"));
                System.out.println("출간일    : " + rs.getString("publish_date"));
                System.out.printf("가격   : %,d원\n", rs.getInt("price"));
            }
            System.out.println("-".repeat(50));
            System.out.println();
        }
    }

    public static void deleteBook() throws ClassNotFoundException, SQLException {
        System.out.print("삭제할 책 번호 입력: ");
        int bookId = Integer.parseInt(scanner.nextLine());

        String sql = "DELETE FROM book WHERE book_id = ?";

        try (
                Connection conn = DBConnectionUtil.getConnection(serviceName, user, password);
                PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, bookId);
            int deleteCount = pstmt.executeUpdate();

            System.out.println(deleteCount == 1 ? "레코드 삭제 성공" : "레코드 삭제 실패");
            System.out.println();
        }
    }
}
