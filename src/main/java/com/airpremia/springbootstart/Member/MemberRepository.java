package com.airpremia.springbootstart.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
