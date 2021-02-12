package Exercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListlyIterator implements  Iterable<String>{
    private List<String> elements;
    private int index;

    public ListlyIterator(String... values) {
        this.elements = Arrays.asList(values);
        this.index = 0;
    }

    public boolean move() {
        if (!this.hasNext()){
            return false;
        }
        index++;
        return true;
    }

    public boolean hasNext(){
        return this.index < this.elements.size()-1;
    }

    public String print(){
        if (this.elements.size()==0){
            throw new UnsupportedOperationException("Invalid Operation!");
        }
       return String.valueOf(elements.get(getIndex()));
    }

    public int getIndex() {
        return index;
    }

    @Override
    public Iterator<String> iterator() {
        return elements.iterator();
//        return new Iterator<String>() {
//            int index = 0;
//            @Override
//            public boolean hasNext() {
//                return this.index <elements.size();
//            }
//
//            @Override
//            public String next() {
//                return elements.get(this.index++);
//            }
//        };
    }
}
