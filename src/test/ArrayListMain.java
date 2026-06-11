package test;

import java.util.ArrayList;

public class ArrayListMain {
    static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("김철수", 20));
        students.add(new Student("이영희", 22));
        students.add(new Student("박민수", 21));

        for (Student student : students) {
            System.out.println(student);
        }

        String findName = "이영희";

        for (Student student : students) {
            if (student.getName().equals(findName)) {
                System.out.println("찾은학생: " + findName);
            }
        }

        String deleteName = "김철수";

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(deleteName)) {
                students.remove(i);
                break;
            }
        }

        for (Student student : students) {
            System.out.println(student);
        }


    }
}
