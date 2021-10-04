package com.spring.corestudy.discount;

import com.spring.corestudy.member.Grade;
import com.spring.corestudy.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {
    private final float DISCOUNT_PERCENT = 10;

    @Override
    public int discount(Member member, int price) {
        return member.getGrade() == Grade.VIP ?
                (int) (price * (DISCOUNT_PERCENT / 100)) : 0;
    }
}
