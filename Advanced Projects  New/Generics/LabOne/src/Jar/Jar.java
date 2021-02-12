package Jar;

import java.util.ArrayDeque;

public class Jar <T> {
    private ArrayDeque<T> data;       //visible only inside the class

    public Jar (){
        this.data = new ArrayDeque<>();
    }

    public void add(T element) {          //method for adding elements
        this.data.push(element);
    }

    public T remove() {                 //method for removing elements
        return  this.data.pop();
    }

}
