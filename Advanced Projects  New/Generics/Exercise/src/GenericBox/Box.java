package GenericBox;

public class Box <T> {
    private Т value;

    public Box (Т value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value+ ": " + value;
    }
}
//50:43