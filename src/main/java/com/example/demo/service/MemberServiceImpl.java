/*
package com.example.demo.service;

import java.util.List;

import com.example.demo.demo.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private Member memberDao;

    @Override
    public Member getMember(Integer memberId) {
        return memberDao.getMemberDO(memberId);
    }

    @Override
    public List<Member> getAllMembers() {
        return null;
    }

    @Override
    public int registerMember(Member member) {
        return memberDao.insertMember(member);
    }

    @Override
    public int updateMember(Member member) {
        return 0;
    }

    @Override
    public int deleteMember(Integer memberId) {
        return memberDao.deleteMember(memberId);
    }


}
*/
