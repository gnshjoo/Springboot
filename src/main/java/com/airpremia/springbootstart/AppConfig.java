package com.airpremia.springbootstart;


import com.airpremia.springbootstart.Discount.DiscountPolicy;
import com.airpremia.springbootstart.Discount.FixDiscountPolicy;
import com.airpremia.springbootstart.Member.MemberRepository;
import com.airpremia.springbootstart.Member.MemberService;
import com.airpremia.springbootstart.Member.MemberServiceImpl;
import com.airpremia.springbootstart.Member.MemoryMemberRepository;
import com.airpremia.springbootstart.Order.OrderService;
import com.airpremia.springbootstart.Order.OrderServiceImpl;

public class AppConfig {
    // 실제 동작에 필요한 구현 객체 생성
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}