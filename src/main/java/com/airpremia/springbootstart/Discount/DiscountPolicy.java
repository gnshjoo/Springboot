package com.airpremia.springbootstart.Discount;

import com.airpremia.springbootstart.Member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
