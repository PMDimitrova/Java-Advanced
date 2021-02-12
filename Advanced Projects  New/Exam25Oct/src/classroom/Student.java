package classroom;

public class Student {
    public String firstName;
    public String lastName;
    public  String bestSubject;

    public Student ( String firstName, String lastName, String bestSubject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }
    public Student(){ //this might be a mistake

    }

    @Override
    public String toString() {
        return String.format("Student: First Name= %s, Last Name= %s, Best Subject= %s",
                this.firstName, this.lastName, this.bestSubject);
    }

    public String getBestSubject() {
        return bestSubject;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
