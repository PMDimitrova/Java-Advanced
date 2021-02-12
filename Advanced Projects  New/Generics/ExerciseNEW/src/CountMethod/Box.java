package CountMethod;

public class Box<T extends Comparable<T>> implements Comparable<T> {
    private T value;

    public Box(T value){
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value.getClass().getName() + ": " + this.value;
    }

    @Override
    public int compareTo(T other) {
        return this.value.compareTo(other);
    }

    public T getValue() {
        return value;
    }
}
