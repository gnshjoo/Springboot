package com.airpremia.springbootstart.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
