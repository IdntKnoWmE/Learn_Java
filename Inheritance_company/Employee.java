package Inheritance_company;

public class Employee extends Person{

    private String empID;
    private double empSalary;
    private String empDepartment;
    private String empTitle;


    public Employee(){}

    public Employee(String empID, Double empSalary, String empDepartment, String empTitle){
        setEmpDepartment(empDepartment);
        setEmpID(empID);
        setEmpSalary(empSalary);
        setEmpTitle(empTitle);
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public void setEmpTitle(String empTitle) {
        this.empTitle = empTitle;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public boolean equal(Object obj){

        if(obj == null) return false;
        else if(this == obj) return true;
        else if(getClass() != obj.getClass()) return false;
        else if(!super.equals(obj)) return false;
        else{
            Employee emp = (Employee) obj;
            return this.empID.equals(emp.empID) &&
                    this.empDepartment.equals(emp.empDepartment) &&
                    this.empSalary == emp.empSalary &&
                    this.empTitle.equals(emp.empTitle) &&
                    this.getName().equals(emp.getName()) &&
                    this.getGender().equals(emp.getGender()) &&
                    this.getAge() == emp.getAge();

        }


    }
}
