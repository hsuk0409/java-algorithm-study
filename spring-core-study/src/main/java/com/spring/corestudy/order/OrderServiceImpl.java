package com.spring.corestudy.order;

import com.spring.corestudy.discount.DiscountPolicy;
import com.spring.corestudy.discount.FixDiscountPolicy;
import com.spring.corestudy.member.Member;
import com.spring.corestudy.member.MemberRepository;
import com.spring.corestudy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
