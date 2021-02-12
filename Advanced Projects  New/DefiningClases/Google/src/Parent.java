public class Parent {
    private String name;
    private String parentBD;

    public Parent(String name, String birthday){
        this.name = name;
        this.parentBD = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.parentBD);
    }
}
