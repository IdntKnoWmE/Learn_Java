package Inheritance_company;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyEmployee {

    static final ArrayList<Company> companies = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter the Company Count");
        int company_count = scanner.nextInt();

        for(int i=0; i<company_count;i++) {
            add_company_and_its_employees();
        }
        print_company_and_its_employees();

        scanner.close();
    }

    public static void add_company_and_its_employees(){

        Scanner scanner = new Scanner(System.in);

        Company company = inputCompany();
        System.out.println("Enter the number of employees in the company: " + company.getCompany_name());
        int emp_count = scanner.nextInt();
        for(int i=0; i<emp_count; i++){
            System.out.println("Enter the employee detail for the company: " + company.getCompany_name());
            company.add_emp(inputEmp());
        }
        companies.add(company);


    }

    public static void print_company_and_its_employees(){

        for (Company company : companies){

            System.out.println("Company Name: " + company.getCompany_name());
            System.out.println("Company has number of employees = " + company.getCompany_emp_count());

            System.out.println("Company Employees are");
            for (Employee employee : company.getCompany_emp()){
                System.out.println(String.format("%s %s %s", employee.getEmpID(), employee.getName(), employee.getEmpTitle()));
            }
        }

    }

    public static Employee inputEmp(){

        Scanner scanner = new Scanner(System.in);
        Employee emp = new Employee();

        System.out.println("Enter Employee Name");
        emp.setName(scanner.next());

        System.out.println("Enter Employee Age");
        emp.setAge(scanner.nextInt());

        System.out.println("Enter Employee Gender Male or Female");
        emp.setGender(scanner.next());

        System.out.println("Enter Employee Salary");
        emp.setEmpSalary(scanner.nextDouble());

        System.out.println("Enter Employee Department");
        emp.setEmpDepartment(scanner.next());

        System.out.println("Enter Employee Title");
        emp.setEmpTitle(scanner.next());


        return emp;

    }

    public static Company inputCompany(){

        Scanner scanner = new Scanner(System.in);
        Company company = new Company();

        System.out.println("Enter Company Name");
        company.setCompany_name(scanner.next());

        return company;
    }

}
