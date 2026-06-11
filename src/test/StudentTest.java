package test;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;

        while (true) {
            System.out.println("""
                1. 학생 등록
                2. 학생 조회
                3. 학생 검색
                4. 학생 삭제
                5. 종료
                """);
            System.out.print("입력 번호: ");
            int menu = scanner.nextInt();
            if (menu == 1) {
                System.out.print("이름: ");
                name = scanner.next();
                System.out.print("나이: ");
                age = scanner.nextInt();

                students.add(new Student(name, age));
                System.out.println();
            } else if (menu == 2) {
                for (Student student : students) {
                    System.out.println(student);
                    System.out.println();
                }
            } else if (menu == 3) {
                System.out.println("검색할 학생의 이름을 입력하시오.");
                name = scanner.next();
                for (Student student : students) {
                    if (student.getName().equals(name)) {
                        System.out.println(student);
                    }
                }

            } else if (menu == 4) {
                System.out.println("학생의 이름을 입력하시오.");
                name = scanner.next();
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getName().equals(name)) {
                        students.remove(i);
                    }
                }
            } else if (menu == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }


    }


}
