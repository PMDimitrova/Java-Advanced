package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... author) {
        this.title = title;
        this.year = year;

        if (author.length == 0) {
            this.authors = new ArrayList<>();
        }else{
            this.authors = new ArrayList<>(Arrays.asList(author));
        }

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    private List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Book other) {
        int result = this.getTitle().compareTo(other.getTitle());
        if (result== 0){
            result = Integer.compare(this.year, other.year);
        }
        return result;
    }
}
