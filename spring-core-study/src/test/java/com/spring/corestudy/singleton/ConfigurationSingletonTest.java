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

        /**
         * @Configuration이 싱글톤 보장하는 이유
         *  1. 해당 Configuration 파일을 빈으로 등록할 때 스프링은 CGLIB 대체 파일을 만들어
         *     기존 소스코드를 조작한다.
         *
         *  2. CGLIB 파일에서는 스프링 컨테이너에 이미 등록된 빈을 찾아서 있으면 기존 것 사용
         *     없으면 기존 로직을 호출해서 새로운 개체를 생성하고 스프링 컨테이너에 등록하기 때문.
         */
        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository).isSameAs(memberRepository2);
    }
}
