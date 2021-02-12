import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine());

        String[] data;

        Map<String, Department> departments = new HashMap<>();

        //department, map<countPeople, totalSalaryPerDepartment>

        for (int i = 0; i < count; i++) {
            data = scan.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            String email = "unknown";
            int age = -1;

            Employee employee;

            if (data.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (data.length == 6) {
                employee = new Employee(name, salary, position, department, email, age);
            } else {
                try {
                    age = Integer.parseInt(data[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    email = data[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }

            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }

        Department maxDep = departments.entrySet().stream()
                .max(Comparator.comparingDouble(f -> f.getValue().getAvgSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxDep.getName());
        maxDep.getEmployees()
                .stream()
                .sorted((f,s) -> Double.compare(s.getSalary(), f.getSalary()))
                .forEach(employee -> {
                    System.out.println(employee.toString());
                });
        System.out.println();
    }

}