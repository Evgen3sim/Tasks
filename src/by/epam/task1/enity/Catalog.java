package by.epam.task1.enity;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<Book> bookList = new ArrayList<Book>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "bookList=" + bookList +
                '}';
    }
}
