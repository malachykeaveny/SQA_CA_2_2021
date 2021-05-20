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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(ArrayList<Criteria> criteria) {
        this.criteria = criteria;
    }
}
