package com.spring.corestudy.singleton;

import com.spring.corestudy.AppConfig;
import com.spring.corestudy.member.MemberRepository;
import com.spring.corestudy.member.MemberServiceImpl;
import com.spring.corestudy.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @DisplayName("스프링 빈 생성 시 각 빈에 동일한 개체는 싱글톤이 유지된다.")
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService.memberRepository= " + memberRepository1);
        System.out.println("orderService.memberRepository= " + memberRepository2);
        System.out.println("memberRepository= " + memberRepository);

        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository).isSameAs(memberRepository2);
    }
}
