package students.subject_management;

import students.academic_management.ManagementService;
import students.academic_management.MenuViewer;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class SubjectManagement implements ManagementService {
    private SubjectDAO subjectDAO = SubjectDAO.getInstance();

    public void read() {
        try {
            List<SubjectDTO> list = subjectDAO.getAllSubjects();

            if (list.isEmpty()) {
                System.out.println("학과 정보가 존재하지 않습니다.");
            } else {
                for (SubjectDTO subjectDTO : list) {
                    System.out.println(subjectDTO);
                }
            }
        } catch (SQLException e) {
            System.out.println("학과 정보를 조회하는 중 오류가 발생했습니다.");
            System.err.println("SQL 오류: " + e.getMessage());
        }
    }

    private SubjectDTO inputData(String mode) {
        String subjectNumber = null;
        String subjectName = null;

        switch (mode) {
            case "insert" -> {
                System.out.print("학과명 입력: ");
                subjectName = MenuViewer.keyboard.nextLine();
            }
            case "update" -> {
                System.out.print("수정할 학과 코드 입력: ");
                subjectNumber = MenuViewer.keyboard.nextLine();
                System.out.print("수정할 학과명 입력: ");
                subjectName = MenuViewer.keyboard.nextLine();
            }
            case "delete" -> {
                System.out.print("삭제할 학과코드 입력: ");
                subjectNumber = MenuViewer.keyboard.nextLine();
            }
            case "search" -> {
                System.out.print("검색할 학과명 입력: ");
                subjectName = MenuViewer.keyboard.nextLine();
            }
        }
        return new SubjectDTO(0, subjectName, subjectNumber);
    }

    public void create() {
        SubjectDTO subjectDTO = inputData("insert");
        try {
            boolean result = subjectDAO.subjectInsert(subjectDTO);
            System.out.println(result ? "학과 데이터 입력 성공" : "학과 데이터 입력 실패");
        } catch (SQLException e) {
            System.out.println("학과 데이터를 입력하는 도중에 오류가 발생했습니다.");
            System.err.println("SQL 오류: " + e.getMessage());
        }
    }

    @Override
    public void update() {
        SubjectDTO subjectDTO = inputData("update");
        try {
            boolean result = subjectDAO.subjectUpdate(subjectDTO);
            System.out.println(result ? "학과 데이터 수정 성공" : "학과 데이터 수정 실패");
        } catch (SQLException e) {
            System.out.println("학과 데이터를 입력하는 중 오류가 발생했습니다.");
            System.err.println("SQL 오류: " + e.getMessage());
        }
    }

    @Override
    public void delete() {
        SubjectDTO subjectDTO = inputData("delete");

        try {
            int studentCount = subjectDAO.studentDataCheck(subjectDTO);

            if (studentCount > 0) {
                System.out.println("해당 학과에 소속된 학생이 있어 학과 데이터를 삭제할 수 없습니다.");
                return;
            }

            System.out.print("입력하신 학과번호로 삭제하시겠습니까? [삭제: 예, 취소: 아니요.]");
            String confirm = MenuViewer.keyboard.next();
            MenuViewer.keyboard.nextLine();

            if ("예".equals(confirm)) {
                boolean result = subjectDAO.subjectDelete(subjectDTO);
                System.out.println(result ? "학과데이터 삭제 성공" : "학과데이터 삭제 실패");
            } else {
                System.out.println("삭제가 취소되었습니다.");
            }
        } catch (SQLException e) {
            System.out.println("학과 데이터를 삭제하는 도중 오류가 발생했습니다.");
            System.err.println("SQL 오류: " + e.getMessage());
        }
    }

    @Override
    public void search() {

    }
}
