package com.example.demo.service;

import com.example.demo.demo.member.Member;

import java.util.List;

public interface MemberService {
    Member getMember(Integer memberId);

    List<Member> getAllMembers();

    int registerMember(Member member);

    int updateMember(Member member);

    int deleteMember(Integer memberId);
}
