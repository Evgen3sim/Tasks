package by.epam.task1.service;

import by.epam.task1.enity.Book;
import by.epam.task1.enity.Catalog;

public class Service {

    public static void addBook(Catalog catalog, Book book){
        catalog.getBookList().add(book);
    }

    public static void removeBook(Catalog catalog, Book book){
        catalog.getBookList().remove(book);
    }

}
