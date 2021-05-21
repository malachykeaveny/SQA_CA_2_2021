public class Student {

    private String studentName;
    private Rubric rubric;

    public Student() {

    }

    public Student(String studentName, Rubric rubric) {
        this.studentName = studentName;
        this.rubric = rubric;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Rubric getRubric() {
        return rubric;
    }

    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }
}
