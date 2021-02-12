package Scale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T right, T left){
        this.right = right;
        this.left  = left;
    }

    public T getHeavier(){
        int compareResult = this.left.compareTo(this.right);
        if (compareResult == 0){
            return null;
        }
        return compareResult > 0 ? this.left :this.right;
    }

}
