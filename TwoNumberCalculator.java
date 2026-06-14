import java.util.Scanner;

public class TwoNumberCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the First number!");
        double firstNumber = scanner.nextDouble();

        System.out.println("Enter the Second number!");
        double secondNumber = scanner.nextDouble();

        System.out.println("Enter the Arithmetic operator");
        char operator = scanner.next().charAt(0);

        scanner.close();

        double result = calculateNumbers(firstNumber, secondNumber, operator);
        System.out.println("The result is: " + result);
    }


    static double calculateNumbers(double firstNumber, double secondNumber, char operator) {

        double result = switch (operator) {
            case '+' -> add(firstNumber, secondNumber);
            case '-' -> subtract(firstNumber, secondNumber);
            case '*' -> multiply(firstNumber, firstNumber);
            case '/' -> divide(firstNumber, secondNumber);
            default -> 0.0;
            };

        return result;
    }

    static double add(double num1, double num2){
        // TODO: Your code goes here
        return num1 + num2;
    }

    static double subtract(double num1, double num2){
        // TODO: Your code goes here
        return num1 - num2;
    }

    static double multiply(double num1, double num2){
        // TODO: Your code goes here
        return num1 * num2;
    }

    static double divide(double num1, double num2){
        // TODO: Your code goes here
        return num1 / num2;
    }
}

