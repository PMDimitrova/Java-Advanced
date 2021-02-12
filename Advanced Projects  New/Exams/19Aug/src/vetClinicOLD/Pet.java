package vetClinicOLD;

public class Pet {
    private String name;
    private int age;
    private String owner;

    Pet (String name, int age, String owner){
        this.name = name;
        this.age = age;
        this.owner = owner;
    }
    Pet (){

    }

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " " + age + " (" + owner + ")";
    }

    public String forClinicStatistics(){
        return name + " " + owner;
    }
}
