package com.airpremia.springbootstart.Order;

import com.airpremia.springbootstart.Discount.DiscountPolicy;
import com.airpremia.springbootstart.Discount.FixDiscountPolicy;
import com.airpremia.springbootstart.Discount.RateDiscountPolicy;
import com.airpremia.springbootstart.Member.Member;
import com.airpremia.springbootstart.Member.MemberRepository;
import com.airpremia.springbootstart.Member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // interface 에 의존하게 코드 변경

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
}
