import java.util.Scanner;

public class GradeFinder {

    public static void main(String[] args) {

        System.out.println("Enter the grade obtained");
        Scanner scanner = new Scanner(System.in);
        char grade = scanner.next().charAt(0);
        scanner.close();


        // Normal Switch case
        switch (grade){
            case 'A':
            {
                System.out.println("You score above 90");
                break;
            }
            case 'B':
            {
                System.out.println("You scored between 80 and 90");
                break;
            }
            case 'C': {
                System.out.println("You scored between 70 and 80");
                break;
            }
            case 'D':
            {
                System.out.println("You scored between 50 and 70");
                break;
            }
            case 'E':
            {
                System.out.println("You scored between 40 and 50");
                break;
            }
            case 'F': {
                System.out.println("You scored less than 40");
                break;
            }
            default:
                System.out.println("Some error while finding score range ....");

        }

        System.out.println("Streamlined switch output: ");

        // Streamlined switch case
        String message = switch (grade){
            case 'A' -> "You score above 90";
            case 'B' -> "You scored between 80 and 90";
            case 'C' -> "You scored between 70 and 80";
            case 'D' -> "You scored between 50 and 70";
            case 'E' -> "You scored between 40 and 50";
            case 'F', 'G' -> "You scored less than 40";
            default -> "Some error while finding score range ....";
        };
        System.out.println(message);

    }
}
