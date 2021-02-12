public class Company {
    private String name = "";
    private String department = "";
    private double salary = 0.0;

    public Company (String name, String department, String salary){
        this.name = name;
        this.department = department;
        this.salary = Double.parseDouble(salary);
    }

    @Override
    public String toString() {
        return String.format("Company:%n%s %s %.2f",
                this.name, this.department,this.salary );
    }
}
