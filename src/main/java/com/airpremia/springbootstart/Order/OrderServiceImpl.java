package com.airpremia.springbootstart.Order;

import com.airpremia.springbootstart.Discount.DiscountPolicy;
import com.airpremia.springbootstart.Discount.FixDiscountPolicy;
import com.airpremia.springbootstart.Member.Member;
import com.airpremia.springbootstart.Member.MemberRepository;
import com.airpremia.springbootstart.Member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice= discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
