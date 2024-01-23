package com.airpremia.springbootstart;

import com.airpremia.springbootstart.Member.Grade;
import com.airpremia.springbootstart.Member.Member;
import com.airpremia.springbootstart.Member.MemberService;
import com.airpremia.springbootstart.Member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findmember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findmember.getName());

    }
}
