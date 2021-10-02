package com.spring.corestudy;

import com.spring.corestudy.discount.DiscountPolicy;
import com.spring.corestudy.discount.RateDiscountPolicy;
import com.spring.corestudy.member.MemberRepository;
import com.spring.corestudy.member.MemberService;
import com.spring.corestudy.member.MemberServiceImpl;
import com.spring.corestudy.member.MemoryMemberRepository;
import com.spring.corestudy.order.OrderService;
import com.spring.corestudy.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
