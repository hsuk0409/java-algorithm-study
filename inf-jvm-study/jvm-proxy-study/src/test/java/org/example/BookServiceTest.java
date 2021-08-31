package org.example;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookServiceTest {
    BookRepository bookRepository = (BookRepository) Proxy.newProxyInstance(BookRepository.class.getClassLoader(), new Class[]{BookRepository.class},
            new InvocationHandler() {
                BookRepository bookRepository = new BookService();

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("aaaa");
                    Object invoke = method.invoke(bookRepository, args);
                    System.out.println("bbbb");
                    return invoke;
                }
            });

    @Test
    public void testDi() {
        Book book = new Book();
        book.setTitle("spring!");
        bookRepository.rent(book);
    }
}