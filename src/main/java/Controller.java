import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    ArrayList<Rubric> rubric = new ArrayList<Rubric>();
    Scanner scanner = new Scanner(System.in);

    public Controller() {
        menu();
    }

    public void menu() {

            System.out.println("-----");
            System.out.println("Please select a menu item");
            System.out.println("1. Create a rubric");
            System.out.println("2. Add criterion to a rubric");
            System.out.println("3. List all rubrics");
            System.out.println("4. Search for rubric");
            System.out.println("5. Close");

            String userChoice = scanner.nextLine();
            //System.out.println(userChoice);

            switch (userChoice) {
                case "1":
                    System.out.println("Enter name for new rubric:");
                    String rubricName = scanner.nextLine();
                    createRubric(rubricName);
                    break;
                case "2":
                    System.out.println("Enter rubric you wish to add criteria to:");
                    String rubricNameC = scanner.nextLine();
                    addCriteria(rubricNameC);
                    break;
                case "3":
                    viewAllRubrics();
                    break;
                case "4":
                    System.out.println("4");
                    break;
                case "5":
                    System.out.println("5");
                    break;
            }
    }


    private void createRubric(String rubricName) {
        Rubric newRubric = new Rubric();
        newRubric.setName(rubricName);
        rubric.add(newRubric);

        System.out.println("Do you want to add criteria to this rubric now? (yes/no)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            addCriteria(rubricName);
        }
        else {
            menu();
        }

    }

    private void addCriteria(String rubricName) {
        System.out.println("Enter criteria name you wish to add to " + rubricName);
        String criteriaName = scanner.nextLine();
        Criteria newCriteria = new Criteria();
        boolean found = false;

        for (Rubric eachRubric : rubric) {
            //System.out.println(eachRubric.getName() + eachRubric.getCriteria());

            if (eachRubric.getName().equalsIgnoreCase(rubricName)) {
                found = true;
                System.out.println("Found " + eachRubric.getName() + eachRubric.getCriteria());
                ArrayList<Criteria> c = eachRubric.getCriteria();

                if (eachRubric.getCriteria().size() <= 10 ) {
                    System.out.println("Size: " + eachRubric.getCriteria().size());
                    Criteria criteria = new Criteria();
                    criteria.setName(criteriaName);
                    criteria.setScoreLimit(5);

                    eachRubric.getCriteria().add(criteria);

                }
                menu();
            }
        }

        if (!found) {
            System.out.println("Rubric not found!");
            menu();
        }

    }

    private void viewAllRubrics() {

        for (Rubric eachRubric : rubric) {
            System.out.println(eachRubric.getName());
        }

        menu();

    }

    public static void main(String[] args) {
        new Controller();
    }

}