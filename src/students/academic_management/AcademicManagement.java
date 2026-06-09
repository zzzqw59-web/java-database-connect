package students.academic_management;

import students.subject_management.SubjectManagement;

public class AcademicManagement {
    public static final int SUBJECT_MANAGEMENT = 1;
    public static final int STUDENT_MANAGEMENT = 2;
    public static final int COURSE_MANAGEMENT = 3;
    public static final int EXIT = 4;

    static void main(String[] args) {
        System.out.println("학사 관리 프로그램을 실행합니다.");

        while (true) {
            MenuViewer.showTopMenu();
            int topMenuChoice = MenuViewer.menuInput();

            switch (topMenuChoice) {
                case SUBJECT_MANAGEMENT -> subMenu(new SubjectManagement());
                case STUDENT_MANAGEMENT -> System.out.println("학생 관리 기능은 추후 구현 예정");
                case COURSE_MANAGEMENT -> System.out.println("과목 관리 기능은 추후 구현 예정");
                case EXIT -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("1~3번중에 골라주세요.");
            }
        }
    }

    private static void subMenu(ManagementService management) {
        MenuViewer.showSubMenu();
        int subMenuChoice = MenuViewer.menuInput();

        switch (subMenuChoice) {
            case 0 -> {
                System.out.println("상위 메뉴로 돌아갑니다. \n");
            }
            case 1 -> management.read();
            case 2 -> management.create();
            case 3 -> management.update();
            case 4 -> management.delete();
            case 5 -> management.search();
            default -> System.out.println("0~5중에 입력하세요.");
        }
    }

}
