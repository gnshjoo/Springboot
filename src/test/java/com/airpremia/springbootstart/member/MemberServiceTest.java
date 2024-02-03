package com.airpremia.springbootstart.member;

import com.airpremia.springbootstart.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

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
