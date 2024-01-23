package com.airpremia.springbootstart;

import com.airpremia.springbootstart.Member.Grade;
import com.airpremia.springbootstart.Member.Member;
import com.airpremia.springbootstart.Member.MemberService;
import com.airpremia.springbootstart.Member.MemberServiceImpl;
import com.airpremia.springbootstart.Order.Order;
import com.airpremia.springbootstart.Order.OrderService;
import com.airpremia.springbootstart.Order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);


        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);

    }
}
