import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTesting {

    Controller controller = new Controller();
    ArrayList<Rubric> rubric = new ArrayList<Rubric>();

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

}
