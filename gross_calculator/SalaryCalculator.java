package gross_calculator;

import java.util.Scanner;

public class SalaryCalculator {

    public static void main(String[] args) {

        // Initialize the value
        double salary = 1000;
        int bonus = 250;
        int quota = 10;

        // Get value of the unknowns
        System.out.println("Enter the sales yo made this week");
        Scanner scanner = new Scanner(System.in);
        var sales = scanner.nextInt();
        scanner.close();

        // Check bonus code
        if(sales > quota && sales <= quota * 2){
            salary = salary + bonus;
        }
        else if(sales > quota*2 && sales <= quota * 3){
            salary = salary + bonus * 1.5;
        } else if(sales > quota*3 && sales <= quota * 4) {
            salary = salary + bonus * 2;
        } else if (sales > quota*4 && sales <= quota * 5) {
            salary = salary + bonus * 2.5;
        }


        System.out.println(salary);

    }
}
