package com.jvm.study.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTest {
    @Autowired BookService bookService;

    @DisplayName("자바 빈 의존성 주입 테스트")
    @Test
    void testOfInjectionBean() {
        Assertions.assertNotNull(bookService);
        Assertions.assertNotNull(bookService.bookRepository);
    }
}