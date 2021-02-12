import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name){
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    //    private String name ="";
//    public List<Employee> employeesOfDepartment = new LinkedList<>();
//    private int countOfEmployees = 0;
//    private double salariesForDepartment = 0;
//
//    public Department(String name){
//        this.name = name;
//        encreaseEmployees(1);
//    }
//
    public void addEmployee (Employee employee){
        employees.add(employee);
    }

    public List<Employee> getEmployees(){
        return employees;
    }
//
//    public void encreaseEmployees(int count) {
//        countOfEmployees++;
//    }
//
//    public void addSalaryToDepartment(double salary) {
//        this.salariesForDepartment += salary;
//    }
//
    public double getAvgSalary() {
        int count = 0;
        double totalSaleForDep = 0;
        for (Employee employee : employees) {
            count++;
            double currentSalary = employee.getSalary();
            totalSaleForDep += currentSalary;
        }
        return totalSaleForDep/count;
    }
}
