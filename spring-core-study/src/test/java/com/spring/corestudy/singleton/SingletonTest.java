package com.spring.corestudy.singleton;

import com.spring.corestudy.AppConfig;
import com.spring.corestudy.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SingletonTest {
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    @Test
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1= " + memberService1);
        System.out.println("memberService2= " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
        assertThat(memberService1.equals(memberService2)).isFalse();
        assertNotEquals(memberService1, memberService2);
    }

    @DisplayName("싱글톤 패턴을 적용한 개체 사용")
    @Test
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @DisplayName("스프링 컨테이너와 싱글톤")
    @Test
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1= " + memberService1);
        System.out.println("memberService2= " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
