import java.util.Scanner;

public class InstantCreditCheck {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your salary");
        double salary = scanner.nextDouble();

        System.out.println("Please enter your Credit Score");
        int credit_score = scanner.nextInt();
        scanner.close();

        boolean check_loan_credibility = checkLoanCredibility(salary, credit_score);

        if(check_loan_credibility) System.out.println("You are eligible for Loan.");
        else System.out.println("Sorry you are not eligible for the loan.");
    }

    public static boolean checkLoanCredibility(double salary, int credit_score){

        double required_salary = 100000;
        int required_credit_score = 750;

        return salary >= required_salary && credit_score >= required_credit_score;
    }
}
