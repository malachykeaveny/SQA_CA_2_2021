import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTesting {

    Controller controller = new Controller();
    ArrayList<Rubric> rubric = new ArrayList<Rubric>();
    //ArrayList<Student> studentGrades = new ArrayList<Student>();

    @Test
    public void testRubricCreation() {
        Rubric rubric1 = new Rubric();
        rubric1.setName("Maths");
        rubric.add(rubric1);
        assertEquals("Maths", rubric1.getName());
    }

    @Test
    public void testCriteria() {
        Criteria criteria = new Criteria();
        criteria.setName("Algebra");
        criteria.setScoreLimit(5);
        assertEquals("Algebra", criteria.getName());
        assertEquals(5, criteria.getScoreLimit());
    }

    @Test
    public void viewAllRubrics() {
        Controller controller = new Controller();
        Rubric rubric1 = new Rubric();
        rubric1.setName("English");
        rubric.add(rubric1);

        //String rubrics = controller.listAllStudentGrades();

        //assertEquals("English", controller.listAllStudentGrades());
    }

    @Test
    public void testStudentGrade() {
        Rubric rubric =  new Rubric();
        Criteria criteria = new Criteria();
        Student student = new Student();

        rubric.setName("Maths");
        criteria.setName("Addition");
        criteria.setScoreLimit(2);
        rubric.getCriteria().add(criteria);
        student.setStudentName("John");
        student.setRubric(rubric);

        assertEquals("Maths", rubric.getName());
        assertEquals("Addition", criteria.getName());
        assertEquals(2, criteria.getScoreLimit());
        assertEquals("John", student.getStudentName());
    }

    @Test
    public void testRubricAverage() {
        Rubric rubric1 =  new Rubric();
        Criteria criteria = new Criteria();
        Criteria criteria1 = new Criteria();
        Student student = new Student();

        rubric1.setName("Maths");

        criteria.setName("Addition");
        criteria.setScoreLimit(2);
        criteria1.setName("Subtraction");
        criteria1.setScoreLimit(4);

        rubric1.getCriteria().add(criteria);
        rubric1.getCriteria().add(criteria1);

        student.setStudentName("John");
        student.setRubric(rubric1);

        controller.studentGrades.add(student);

        assertEquals(3.0, controller.averageRubricScore("Maths"));
    }

    @Test
    public void testCriteriaAverage() {
        Rubric rubric1 =  new Rubric();
        Criteria criteria = new Criteria();
        Criteria criteria1 = new Criteria();
        Student student = new Student();
        Student student1 = new Student();

        rubric1.setName("Maths");

        criteria.setName("Addition");
        criteria.setScoreLimit(2);
        criteria1.setName("Addition");
        criteria1.setScoreLimit(4);

        rubric1.getCriteria().add(criteria);
        rubric1.getCriteria().add(criteria1);

        student.setStudentName("John");
        student.setRubric(rubric1);

        student1.setStudentName("Paul");
        student1.setRubric(rubric1);

        controller.studentGrades.add(student);

        assertEquals(3.0, controller.averageCriteriaScore("Maths", "Addition"));
    }

    @Test
    public void testRubricMinimum() {
        Rubric rubric1 =  new Rubric();
        Criteria criteria = new Criteria();
        Criteria criteria1 = new Criteria();
        Student student = new Student();

        rubric1.setName("Maths");

        criteria.setName("Addition");
        criteria.setScoreLimit(2);
        criteria1.setName("Subtraction");
        criteria1.setScoreLimit(4);

        rubric1.getCriteria().add(criteria);
        rubric1.getCriteria().add(criteria1);

        student.setStudentName("John");
        student.setRubric(rubric1);

        controller.studentGrades.add(student);

        assertEquals(2, controller.minimumRubricScore("Maths"));
    }

    @Test
    public void testRubricMaximum() {
        Rubric rubric1 =  new Rubric();
        Criteria criteria = new Criteria();
        Criteria criteria1 = new Criteria();
        Student student = new Student();

        rubric1.setName("Maths");

        criteria.setName("Addition");
        criteria.setScoreLimit(2);
        criteria1.setName("Subtraction");
        criteria1.setScoreLimit(4);

        rubric1.getCriteria().add(criteria);
        rubric1.getCriteria().add(criteria1);

        student.setStudentName("John");
        student.setRubric(rubric1);

        controller.studentGrades.add(student);

        assertEquals(4, controller.maximumRubricScore("Maths"));
    }

    @Test
    public void testCriteriaMinimum() {
        Rubric rubric1 =  new Rubric();
        Criteria criteria = new Criteria();
        Criteria criteria1 = new Criteria();
        Student student = new Student();
        Student student1 = new Student();

        rubric1.setName("Maths");

        criteria.setName("Addition");
        criteria.setScoreLimit(2);
        criteria1.setName("Addition");
        criteria1.setScoreLimit(4);

        rubric1.getCriteria().add(criteria);
        rubric1.getCriteria().add(criteria1);

        student.setStudentName("John");
        student.setRubric(rubric1);

        student1.setStudentName("Paul");
        student1.setRubric(rubric1);

        controller.studentGrades.add(student);

        assertEquals(2, controller.minimumCriteriaScore("Maths", "Addition"));
    }

    @Test
    public void testCriteriaMaximum() {
        Rubric rubric1 =  new Rubric();
        Criteria criteria = new Criteria();
        Criteria criteria1 = new Criteria();
        Student student = new Student();
        Student student1 = new Student();

        rubric1.setName("Maths");

        criteria.setName("Addition");
        criteria.setScoreLimit(2);
        criteria1.setName("Addition");
        criteria1.setScoreLimit(4);

        rubric1.getCriteria().add(criteria);
        rubric1.getCriteria().add(criteria1);

        student.setStudentName("John");
        student.setRubric(rubric1);

        student1.setStudentName("Paul");
        student1.setRubric(rubric1);

        controller.studentGrades.add(student);

        assertEquals(4, controller.maximumCriteriaScore("Maths", "Addition"));
    }

    @Test
    public void testRubricStandardDev() {
        Rubric rubric1 =  new Rubric();
        Criteria criteria = new Criteria();
        Criteria criteria1 = new Criteria();
        Student student = new Student();
        Student student1 = new Student();

        rubric1.setName("Maths");

        criteria.setName("Addition");
        criteria.setScoreLimit(2);
        criteria1.setName("Addition");
        criteria1.setScoreLimit(4);

        rubric1.getCriteria().add(criteria);
        rubric1.getCriteria().add(criteria1);

        student.setStudentName("John");
        student.setRubric(rubric1);

        student1.setStudentName("Paul");
        student1.setRubric(rubric1);

        controller.studentGrades.add(student);

        assertEquals(1.0, controller.rubricStandardDev("Maths"));
    }

    @Test
    public void testCriteriaStandardDev() {
        Rubric rubric1 =  new Rubric();
        Criteria criteria = new Criteria();
        Criteria criteria1 = new Criteria();
        Student student = new Student();
        Student student1 = new Student();

        rubric1.setName("Maths");

        criteria.setName("Addition");
        criteria.setScoreLimit(2);
        criteria1.setName("Addition");
        criteria1.setScoreLimit(4);

        rubric1.getCriteria().add(criteria);
        rubric1.getCriteria().add(criteria1);

        student.setStudentName("John");
        student.setRubric(rubric1);

        student1.setStudentName("Paul");
        student1.setRubric(rubric1);

        controller.studentGrades.add(student);

        assertEquals(1.0, controller.criteriaStandardDev("Maths", "Addition"));
    }

}
