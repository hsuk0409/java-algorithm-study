package com.spring.corestudy;

import com.spring.corestudy.member.Grade;
import com.spring.corestudy.member.Member;
import com.spring.corestudy.member.MemberService;
import com.spring.corestudy.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        assert member.getName().equals(findMember.getName());
    }
}
