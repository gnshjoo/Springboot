package com.airpremia.springbootstart.order;

import com.airpremia.springbootstart.discount.DiscountPolicy;
import com.airpremia.springbootstart.member.Member;
import com.airpremia.springbootstart.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // interface 에 의존하게 코드 변경

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // OCP, DIP 위반 (변경이 필요할 때마다 코드를 수정해야 함)
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice= discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}