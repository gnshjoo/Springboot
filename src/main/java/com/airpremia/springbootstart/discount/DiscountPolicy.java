package com.airpremia.springbootstart.discount;

import com.airpremia.springbootstart.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
