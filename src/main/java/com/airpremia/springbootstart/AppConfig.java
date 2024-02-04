package com.airpremia.springbootstart;


import com.airpremia.springbootstart.discount.DiscountPolicy;

import com.airpremia.springbootstart.discount.RateDiscountPolicy;
import com.airpremia.springbootstart.member.MemberRepository;
import com.airpremia.springbootstart.member.MemberService;
import com.airpremia.springbootstart.member.MemberServiceImpl;
import com.airpremia.springbootstart.member.MemoryMemberRepository;
import com.airpremia.springbootstart.order.OrderService;
import com.airpremia.springbootstart.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // 실제 동작에 필요한 구현 객체 생성

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()

    // 생각하는 의도
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository


    // 동작하는 방법
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService

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
 // return new FixDiscountPolicy(); // 이것만 수정하면 DiscountPolicy 를 변경할 수 있음
        return new RateDiscountPolicy();
    }

}
