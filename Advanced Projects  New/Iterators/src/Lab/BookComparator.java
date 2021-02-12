package Lab;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    private int result;

    @Override
    public int compare(Book first, Book second) {
        int result;
        result = first.getTitle().compareTo(second.getTitle());
        if (result == 0){
            result = Integer.compare(first.getYear(), second.getYear());
        }
        return result;
    }
}

