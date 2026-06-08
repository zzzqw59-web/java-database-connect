package subject_management;

public class SubjectDTO {
    private int no;
    private String subjectNumber;
    private String subjectName;

    public SubjectDTO() {
    }

    public SubjectDTO(int no, String subjectName, String subjectNumber) {
        this.no = no;
        this.subjectName = subjectName;
        this.subjectNumber = subjectNumber;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(String subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    @Override
    public String toString() {
        return "SubjectVO{" +
                "no=" + no +
                ", subjectNumber='" + subjectNumber + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
