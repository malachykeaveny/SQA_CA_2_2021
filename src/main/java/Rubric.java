import java.util.ArrayList;

public class Rubric {

    private String name;
    private ArrayList<Criteria> criteria = new ArrayList<Criteria>();

    public Rubric() {

    }

    public Rubric(String name, ArrayList<Criteria> criteria) {
        this.name = name;
        this.criteria = criteria;
    }

}
