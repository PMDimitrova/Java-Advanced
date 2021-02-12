public class Child {
    private String kidsName;
    private String kidsBD;

    public Child(String name, String birthday){
        this.kidsName = name;
        this.kidsBD = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.kidsName, this.kidsBD);
    }
}
