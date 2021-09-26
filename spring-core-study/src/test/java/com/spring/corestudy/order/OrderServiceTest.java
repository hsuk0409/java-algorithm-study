package com.spring.corestudy.order;

import com.spring.corestudy.AppConfig;
import com.spring.corestudy.member.Grade;
import com.spring.corestudy.member.Member;
import com.spring.corestudy.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @DisplayName("할인 정책을 적용한 주문 개체 생성 테스트")
    @Test
    void createdOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
