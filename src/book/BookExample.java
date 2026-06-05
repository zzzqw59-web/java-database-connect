package book;

import java.sql.SQLException;
import java.util.Date;
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
                2. 데이터 검색
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
        Date publisherDate;

        System.out.println("[도서 정보 입력]");
        System.out.print("책이름 입력: ");
        title = scanner.nextLine();

        System.out.print("저자 입력: ");
        author = scanner.nextLine();

        System.out.print("출판사 입력: ");
        publisher = scanner.nextLine();
    }
}
