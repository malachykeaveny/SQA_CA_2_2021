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

}
