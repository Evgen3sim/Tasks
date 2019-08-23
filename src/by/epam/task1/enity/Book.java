package by.epam.task1.enity;

import java.util.Objects;

public class Book {

    private String nameBook;
    private String author;
    private String electronic;

    public Book(String nameBook, String author, String electronic) {
        this.nameBook = nameBook;
        this.author = author;
        this.electronic = electronic;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String isElectronic() {
        return electronic;
    }

    public void setElectronic(String electronic) {
        this.electronic = electronic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return electronic == book.electronic &&
                Objects.equals(nameBook, book.nameBook) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameBook, author, electronic);
    }

    @Override
    public String toString() {
        return "Book{" +
                "nameBook='" + nameBook + '\'' +
                ", author='" + author + '\'' +
                ", electronic=" + electronic +
                '}' + "\n";
    }
}
