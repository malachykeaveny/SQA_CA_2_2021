import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    ArrayList<Rubric> rubric = new ArrayList<Rubric>();
    public ArrayList<Student> studentGrades = new ArrayList<Student>();
    Scanner scanner = new Scanner(System.in);

    public Controller() {
        //menu();
    }

    public void menu() {

            System.out.println("----------");
            System.out.println("Please select a menu item");
            System.out.println("1. Create a rubric");
            System.out.println("2. Add criterion to a rubric");
            System.out.println("3. View all rubrics");
            System.out.println("4. Search for rubric");
            System.out.println("5. Create a student grade");
            System.out.println("6. View all student grades for a rubric");
            System.out.println("7. View all student grades");
            System.out.println("8. View grade summaries");
            System.out.println("9. View criterion summary for specific grade");
            System.out.println("10. Close");
            System.out.println("----------");

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
                    System.out.println("Enter rubric you wish to add criteria to:");
                    String rubricNameSearch = scanner.nextLine();
                    searchForRubric(rubricNameSearch);
                    System.out.println("4");
                    break;
                case "5":
                    createStudentGrade();
                    break;
                case "6":
                    System.out.println("Enter rubric you wish to view all student scores for:");
                    String rubricNameStudents = scanner.nextLine();
                    listAllStudentGradesforRubric(rubricNameStudents);
                break;
                case "7":
                    listAllStudentGrades();
                    break;
                case "8":
                    System.out.println("Enter rubric you wish to receive a summary of: ");
                    String rubricNameSummary = scanner.nextLine();
                    if (averageRubricScore(rubricNameSummary) != 0) {
                        System.out.println("Summary for " + rubricNameSummary);
                        System.out.println("----------");
                        System.out.println("Average: " + averageRubricScore(rubricNameSummary));
                        System.out.println("Maximum: " + maximumRubricScore(rubricNameSummary));
                        System.out.println("Minimum: " + minimumRubricScore(rubricNameSummary));
                        System.out.println("Standard deviation: " + rubricStandardDev(rubricNameSummary));
                        System.out.println("----------");
                    }
                    else {
                        System.out.println("Rubric does not exist!");
                    }
                    menu();
                    break;
                case "9":
                    System.out.println("Enter rubric you wish to receive a summary of: ");
                    String rubricNameSummary2 = scanner.nextLine();
                    System.out.println("Enter criterion you wish to receive a summary of: ");
                    String criterionNameSummary = scanner.nextLine();

                    if (averageCriteriaScore(rubricNameSummary2,criterionNameSummary) != 0) {
                        System.out.println("----------");
                        System.out.println("Average: " + averageCriteriaScore(rubricNameSummary2,criterionNameSummary));
                        System.out.println("Maximum: " + maximumCriteriaScore(rubricNameSummary2,criterionNameSummary));
                        System.out.println("Minimum: " + minimumCriteriaScore(rubricNameSummary2,criterionNameSummary));
                        System.out.println("Standard deviation:: " + criteriaStandardDev(rubricNameSummary2,criterionNameSummary));
                        System.out.println("----------");
                    }
                    else {
                        System.out.println("Criteria does not exist!");
                    }

                    menu();
                    break;
            }
    }

    public void listAllStudentGrades() {
        for (Student student : studentGrades) {
            System.out.println("----------");
            System.out.println(student.getStudentName());
            System.out.println("----------");
            System.out.println(student.getRubric().getName());

            for (Criteria criteria : student.getRubric().getCriteria()) {
                System.out.println(criteria.getName() + " " + criteria.getScoreLimit());
            }
            System.out.println("----------");
        }

        menu();
    }

    private void listAllStudentGradesforRubric(String rubricNameStudents) {
        ArrayList<Student> allGradesList = new ArrayList<Student>();

        for (Student student : studentGrades) {

            if (student.getRubric().getName().equalsIgnoreCase(rubricNameStudents)) {
                allGradesList.add(student);
                System.out.println(student.getStudentName() + " " + student.getRubric());
            }
        }

    }

    private void createStudentGrade() {
        Rubric rubric1 = new Rubric();
        System.out.println("Which rubric would you like to use?");
        String rubricName = scanner.nextLine();
        System.out.println("Which student would you like to grade?");
        String studentName = scanner.nextLine();


        for (Rubric eachRubric : rubric) {
            if (eachRubric.getName().equalsIgnoreCase(rubricName)) {
                //At this point we have identified the rubric and the student to be graded

                for (Criteria criteria : eachRubric.getCriteria()) {
                    //System.out.println(criteria.getName());
                    System.out.println("Add student grade for " + criteria.getName());
                    String criteriaGrade = scanner.nextLine();

                    if (Integer.parseInt(criteriaGrade) >= 0 && Integer.parseInt(criteriaGrade) <= 5) {
                        Criteria criteria1 = new Criteria();
                        //System.out.println("Criteria check: " + criteria.getName() + " " + criteriaGrade);
                        criteria1.setName(criteria.getName());
                        criteria1.setScoreLimit(Integer.parseInt(criteriaGrade));
                        rubric1.setName(eachRubric.getName());
                        rubric1.getCriteria().add(criteria1);
                        //System.out.println(rubric1.getName());
                    }
                }

                Student student = new Student();
                student.setStudentName(studentName);
                student.setRubric(rubric1);
                studentGrades.add(student);

                menu();

            }
            else {
                System.out.println("Error, that rubric does not exist!");
                menu();
            }
        }
    }

    private void searchForRubric(String rubricNameSearch) {

        for (Rubric eachRubric : rubric) {

            if (eachRubric.getName().equalsIgnoreCase(rubricNameSearch)) {
                System.out.println(eachRubric.getName());
            }

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
                    //System.out.println("Size: " + eachRubric.getCriteria().size());
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

    public void viewAllRubrics() {

        for (Rubric eachRubric : rubric) {
            System.out.println(eachRubric.getName());
        }

        menu();

    }

    public Double averageRubricScore(String rubricName) {

        int sumTotalScore = 0;
        int count = 0;
        double averageScore = 0;

        for (Student student : studentGrades) {

            if (student.getRubric().getName().equalsIgnoreCase(rubricName)) {
                for (Criteria criteria : student.getRubric().getCriteria()) {
                    sumTotalScore += criteria.getScoreLimit();
                    count += 1;
                }
            }
        }

        if (count != 0) {
            averageScore = sumTotalScore / count;
        }

        return averageScore;
    }

    public Double averageCriteriaScore(String rubricName, String criteriaName) {

        int sumTotalScore = 0;
        int count = 0;
        double averageScore = 0;

        for (Student student : studentGrades) {

            if (student.getRubric().getName().equalsIgnoreCase(rubricName)) {
                for (Criteria criteria : student.getRubric().getCriteria()) {
                    if (criteria.getName().equalsIgnoreCase(criteriaName)) {
                        sumTotalScore += criteria.getScoreLimit();
                        count += 1;
                    }
                }
            }
        }

        averageScore = sumTotalScore / count;

        return averageScore;
    }

    public int minimumRubricScore(String rubricName) {

        // I've set the smallest number to be 6 so that the first element in the list will always be smaller,
        // and therefor be assigned as the smallest num on the first loop.

        int smallestNum = 6;

        for (Student student : studentGrades) {
            if (student.getRubric().getName().equalsIgnoreCase(rubricName)) {
                for (Criteria criteria : student.getRubric().getCriteria()) {
                    if (criteria.getScoreLimit() < smallestNum) {
                        smallestNum = criteria.getScoreLimit();
                    }
                }
            }
        }

        return smallestNum;
    }

    public int minimumCriteriaScore(String rubricName, String criteriaName) {

        // I've set the smallest number to be 6 so that the first element in the list will always be smaller,
        // and therefor be assigned as the smallest num on the first loop.

        int smallestNum = 6;

        for (Student student : studentGrades) {
            if (student.getRubric().getName().equalsIgnoreCase(rubricName)) {
                for (Criteria criteria : student.getRubric().getCriteria()) {
                    if (criteria.getName().equalsIgnoreCase(criteriaName)) {
                        if (criteria.getScoreLimit() < smallestNum) {
                            smallestNum = criteria.getScoreLimit();
                        }
                    }
                }
            }
        }

        return smallestNum;
    }

    public int maximumRubricScore(String rubricName) {

        int largestNum = 0;

        for (Student student : studentGrades) {
            if (student.getRubric().getName().equalsIgnoreCase(rubricName)) {
                for (Criteria criteria : student.getRubric().getCriteria()) {
                    if (criteria.getScoreLimit() > largestNum) {
                        largestNum = criteria.getScoreLimit();
                    }
                }
            }
        }

        return largestNum;
    }

    public int maximumCriteriaScore(String rubricName, String criteriaName) {

        int largestNum = 0;

        for (Student student : studentGrades) {
            if (student.getRubric().getName().equalsIgnoreCase(rubricName)) {
                for (Criteria criteria : student.getRubric().getCriteria()) {
                    if (criteria.getName().equalsIgnoreCase(criteriaName)) {
                        if (criteria.getScoreLimit() > largestNum) {
                            largestNum = criteria.getScoreLimit();
                        }
                    }
                }
            }
        }

        return largestNum;
    }

    public Double rubricStandardDev(String rubricNameSummary) {

        int sum = 0;
        double mean = 0;
        double standardDev = 0.0;
        ArrayList<Integer> studentGradesList = new ArrayList<Integer>();

        for (Student student : studentGrades) {
            if (student.getRubric().getName().equalsIgnoreCase(rubricNameSummary)) {
                for (Criteria criteria : student.getRubric().getCriteria()) {
                    sum += criteria.getScoreLimit();
                    studentGradesList.add(criteria.getScoreLimit());
                }
            }
        }

        mean = sum / studentGradesList.size();

        for (int i = 0; i < studentGradesList.size(); i++) {
            standardDev += Math.pow(studentGradesList.get(i) - mean, 2);
        }

        standardDev = standardDev / studentGradesList.size();

        return standardDev;
    }

    public Double criteriaStandardDev(String rubricNameSummary, String criteriaName) {

        int sum = 0;
        double mean = 0;
        double standardDev = 0.0;
        ArrayList<Integer> studentGradesList = new ArrayList<Integer>();

        for (Student student : studentGrades) {
            if (student.getRubric().getName().equalsIgnoreCase(rubricNameSummary)) {
                for (Criteria criteria : student.getRubric().getCriteria()) {
                    if (criteria.getName().equalsIgnoreCase(criteriaName)) {
                        sum += criteria.getScoreLimit();
                        studentGradesList.add(criteria.getScoreLimit());
                    }
                }
            }
        }

        mean = sum / studentGradesList.size();

        for (int i = 0; i < studentGradesList.size(); i++) {
            standardDev += Math.pow(studentGradesList.get(i) - mean, 2);
        }

        standardDev = standardDev / studentGradesList.size();

        return standardDev;
    }

    public static void main(String[] args) {
        new Controller();
    }

}