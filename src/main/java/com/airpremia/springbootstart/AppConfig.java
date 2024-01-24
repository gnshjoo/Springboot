package com.airpremia.springbootstart;


import com.airpremia.springbootstart.Discount.DiscountPolicy;

import com.airpremia.springbootstart.Discount.RateDiscountPolicy;
import com.airpremia.springbootstart.Member.MemberRepository;
import com.airpremia.springbootstart.Member.MemberService;
import com.airpremia.springbootstart.Member.MemberServiceImpl;
import com.airpremia.springbootstart.Member.MemoryMemberRepository;
import com.airpremia.springbootstart.Order.OrderService;
import com.airpremia.springbootstart.Order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // 실제 동작에 필요한 구현 객체 생성
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
 // return new FixDiscountPolicy(); // 이것만 수정하면 DiscountPolicy 를 변경할 수 있음
        return new RateDiscountPolicy();
    }

}
