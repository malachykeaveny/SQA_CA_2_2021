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
                    System.out.println("1");
                    menu();
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.println("4");
                    break;
                case "5":
                    System.out.println("5");
                    break;
            }
    }

    public static void main(String[] args) {
        new Controller();
    }

}