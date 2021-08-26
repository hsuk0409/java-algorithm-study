package com.jvm.study;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;
        System.out.println("Super Class Of Book::" + bookClass.getSuperclass());
        System.out.println("Super Class Of Book::" + MyBook.class.getSuperclass());

        System.out.println();
        System.out.println("Book Class Fields");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        System.out.println();
        System.out.println("Book Class Constructors");
        Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);

        System.out.println();
        System.out.println("Book Class Methods");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        System.out.println();
        System.out.println("Book Class Annotations");
        Arrays.stream(bookClass.getDeclaredAnnotations()).forEach(System.out::println);
        System.out.println("MyBook Class Annotations");
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        System.out.println("Get Annotation Fields Value");
        Arrays.stream(Book.class.getDeclaredFields()).forEach(
                f -> Arrays.stream(f.getAnnotations()).forEach(a -> {
                    if (a instanceof MyAnnotation) {
                        MyAnnotation myAnnotation = (MyAnnotation) a;
                        System.out.println(myAnnotation.value());
                        System.out.println(myAnnotation.number());
                    }
        }));
    }
}
