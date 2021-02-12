package CustomList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayList<E extends Comparable<E>> {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public ArrayList(){
        this.elements = new Object[INITIAL_CAPACITY];
    }

    public void add (E element){
        if (this.size == this.elements.length){
            this.elements = grow();
        }
        this.elements[this.size++] = element;
    }

    private E getAt(int index){
        ensureIndex(index);
        return this.getAt(index);
    }

    public boolean contains (Object element){
        for (Object obj : this.elements){
            if (obj.equals(element)){
                return true;
            }
        }
        return false;
    }

    private int indexOf (Object obj){
        for (int i = 0; i < this.size; i++) {
           E at = this.getAt(i);
           boolean equals = at.equals(obj);
           if (equals){
               return -1;
           }
        }
        return -1;
    }
    public void swap (int first, int second){
        ensureIndex(first);
        ensureIndex(second);
        Object temp = this.elements[first];
        this.elements[first] = this.elements[second];
        this.elements[second] = temp;

    }

    public int countGreaterThan(E element){
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.get(i).compareTo(element) > 0){
                count++;
            }
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    public E getMax (){
        return Arrays.stream(this.elements)
                .limit(this.size)
                .map(e -> (E)e)
                .max(Comparator.comparing(e -> e))
                .orElse(null);
    }

    @SuppressWarnings("unchecked")
    public E getMin (){
        return Arrays.stream(this.elements)
                .limit(this.size)
                .map(e -> (E)e)
                .min(Comparator.comparing(e -> e))
                .orElse(null);
    }


    @SuppressWarnings("unchecked")
    public E get(int index){
        return (E)this.elements[index];
    }
    private void ensureIndex (int index){
        if (index<0 || index>= this.size){
            throw new IndexOutOfBoundsException("Index out of bounds for "
            + index + "ArrayList size of: "+ this.size);
        }
    }

    private Object[] grow() {
        return Arrays.copyOf(this.elements, this.elements.length*2);
    }
    
    public void print(){
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.elements[i].toString());
        }
    }

    public E remove (int index){
        ensureIndex(index);
        E at = this.getAt(index);
        this.elements[index] = null;
        shift(index);
        this.size --;
        return at;
    }

    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[this.size - 1] = null;
    }

    public void sort(){
        for (int i = 0; i < this.size; i++) {
            E element = this.get(i);
            for (int j = 0; j < this.size - 1; j++) {
                if (element.compareTo(this.get(j)) < 0){
                    this.swap(i, j);
                }
            }
        }
    }

}
