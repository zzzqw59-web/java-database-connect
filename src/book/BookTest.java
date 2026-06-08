package book;

import java.sql.SQLException;
import java.util.Scanner;

public class BookTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            try {
                BookExample.showMenu();
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> BookExample.addBlock();
                    case 2 -> BookExample.readBook();
                    case 3 -> BookExample.deleteBook();
                    case 4 -> {
                        System.out.println("프로그램을 종료합니다.");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("잘못된 메뉴 번호입니다. \n");
                }
            } catch (NumberFormatException e) {
                System.out.println("입력 ERROR");
                System.out.println("숫자는 올바른 정수 형식으로 입력해야 합니다. \n");
            } catch (IllegalArgumentException e) {
                System.out.println("입력 ERROR");
                System.out.println("출간일은 YYYY-MM-DD 형식으로 입력해야 합니다.");
            } catch (ClassNotFoundException e) {
                System.out.println("드라이버 에러: 드라이버를 찾을 수 없습니다.");
            } catch (SQLException e) {
                System.out.println("쿼리문 에러: " + e.getMessage());
            }
        }
    }
}
