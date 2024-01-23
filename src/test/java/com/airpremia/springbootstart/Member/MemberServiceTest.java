package com.airpremia.springbootstart.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl(); // 구현제 의존 ( 추상화, 구체화 동시에 의존 ) DIP 위반

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findmember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findmember);
    }
}
