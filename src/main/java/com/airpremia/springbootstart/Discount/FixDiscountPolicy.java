package com.airpremia.springbootstart.Discount;

import com.airpremia.springbootstart.Member.Grade;
import com.airpremia.springbootstart.Member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
