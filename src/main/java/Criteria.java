public class Criteria {

    private String name;
    private int scoreLimit;

    public Criteria() {

    }

    public  Criteria(String name, int scoreLimit) {
        this.name = name;
        this.scoreLimit = scoreLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScoreLimit() {
        return scoreLimit;
    }

    public void setScoreLimit(int scoreLimit) {
        this.scoreLimit = scoreLimit;
    }
}
