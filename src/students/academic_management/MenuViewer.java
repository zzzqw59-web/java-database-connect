package students.academic_management;

import java.util.Scanner;

public class MenuViewer {
    public static Scanner keyboard = new Scanner(System.in);

    public static void showTopMenu() {
        System.out.println("""
                선택하세요.
                1. 학과 관리
                2. 학생 관리
                3. 과목 관리
                4. 프로그램 종료
                """);
    }

    public static void showSubMenu() {
        System.out.println("""
                
                0. 상위메뉴 돌아가기
                1. 데이터 조회
                2. 데이터 입력
                3. 데이터 수정
                4. 데이터 삭제
                5. 데이터 검색(학과명)
                """);
    }

    public static int menuInput() {
        while (true) {
            System.out.print("선택 >> ");
            try {
                return Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("메뉴는 정수 타입으로만 입력해야 합니다.");
            }

        }
    }
}
