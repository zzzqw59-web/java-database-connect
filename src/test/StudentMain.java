package test;

import java.util.ArrayList;

public class StudentMain {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("김철수", 20));
        students.add(new Student("이영희", 35));
        students.add(new Student("김준표", 12));

        for (Student student : students) {
            System.out.println(student);
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals("이영희")) {
                System.out.println("이영희");
            }
        }

        Student oldset = students.get(0);

        for (Student student : students) {
            if (student.getAge() > oldset.getAge()) {
                oldset = student;
            }
        }
        System.out.println(oldset);

        int sum = 0;
        double average = 0;

        for (Student student : students) {
            sum += student.getAge();
        }

        average = (double) sum / students.size();
        System.out.println(average);

        Student yongest = students.get(0);

        for (Student student : students) {
            if (yongest.getAge() > student.getAge()) {
                yongest = student;
            }
        }
        System.out.println(yongest);

        for (Student student : students) {
            if (student.getAge() >= 20) {
                System.out.println(student);
            }
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals("김준표")) {
                students.remove(i);
            }
        }
        System.out.println(students);
    }
}
