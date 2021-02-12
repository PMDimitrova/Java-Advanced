public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;     //optional
    private int age;          //optional            1:03:00

    public Employee(String name, double salary, String position, String department){
        this.name = name;
        this.salary = salary;
        this. position = position;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);       //constructor chaining - така извикваме горния конструктор
        this.email = email;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);       //constructor chaining - така извикваме горния конструктор
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department, email);       //constructor chaining - така извикваме горния конструктор
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString(){
      return String.format("%s %.2f %s %d",
              this.name, this.salary, this.email, this.age);
    }
}
