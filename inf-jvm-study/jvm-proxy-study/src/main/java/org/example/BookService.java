package org.example;

public class BookService implements BookRepository {

    @Override
    public void rent(Book book) {
        System.out.println("rent:" + book.getTitle());
    }
}
