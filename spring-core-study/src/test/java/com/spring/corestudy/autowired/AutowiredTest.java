package com.spring.corestudy.autowired;

import com.spring.corestudy.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @DisplayName("자동주입 옵션 테스트")
    @Test
    void autowiredOptional() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
    }

    static class TestConfig {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("TestConfig.setNoBean1= " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("TestConfig.setNoBean2= " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("TestConfig.setNoBean3= " + noBean3);
        }
    }
}
