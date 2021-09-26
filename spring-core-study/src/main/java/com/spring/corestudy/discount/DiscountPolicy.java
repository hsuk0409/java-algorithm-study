package com.spring.corestudy.discount;

import com.spring.corestudy.member.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
