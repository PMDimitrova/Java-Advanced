package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public String getStatistics(){      //there's no demo output here!!!!!!
        String output = "Classroom size: " + this.students.size();
        for (Student student:this.students) {
            output +=  System.lineSeparator() + "==" + student.toString();
        }
        return output;
    }


    public Student getStudent(String firstName, String lastName) {
        Student output = new Student();
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName) &&
                    student.getLastName().equals(lastName)){
                output = student;
            }
        }
        return output;
    }

    public String getSubjectInfo(String subject){
        String output = "none";

        for (Student student: students) {
            if (student.getBestSubject().equals(subject)){
                output = "Subject: " + subject + System.lineSeparator()+ "Students:";//HERE
            }
        }
        for (Student student: students) {
            if (student.getBestSubject().equals(subject)){
                output += System.lineSeparator() + student.getFirstName() + " " + student.getLastName();
            }
        }

        if (output.equals("none")){
            output = "No students enrolled for the subject"; //HERE
        }
        return output;

    }

    public String dismissStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public String registerStudent(Student student) {
        if (this.students.contains(student)) {
            return "Student is already in the classroom";
        } else if (this.students.size() < this.capacity) {
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(),
                    student.getLastName());
        } else {
            return "No seats in the classroom";
        }
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public List<Student> getStudents() {    //is this the right return type?
        return this.students;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
