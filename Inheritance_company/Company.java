package Inheritance_company;

import java.util.ArrayList;

public class Company {

    private String company_name;
    private int company_emp_count = 0;

    public int getCompany_emp_count() {
        return company_emp_count;
    }

    public ArrayList<Employee> getCompany_emp() {
        return company_emp;
    }

    final ArrayList<Employee> company_emp = new ArrayList<>();

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public void add_emp(Employee emp){
        emp.setEmpID(emp.getName() + "_" + (company_emp_count+1));
        company_emp.add(emp);
        company_emp_count += 1;
    }
    public void remove_emp(Employee emp){
        if(company_emp.contains(emp)){
            company_emp.remove(emp);
            company_emp_count -= 1;
        }
        else System.out.println("No Such Employee exist in the Company");
    }

}
