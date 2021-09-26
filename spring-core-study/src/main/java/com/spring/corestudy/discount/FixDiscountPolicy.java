package com.spring.corestudy.discount;

import com.spring.corestudy.member.Grade;
import com.spring.corestudy.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private final int DISCOUNT_FIX_AMOUNT = 1000;

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ? DISCOUNT_FIX_AMOUNT : 0;
    }
}
