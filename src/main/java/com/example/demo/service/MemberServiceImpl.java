package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.domain.MemberDO;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public MemberDO getMember(Integer memberId) {
        return memberDao.getMemberDO(memberId);
    }

    @Override
    public List<MemberDO> getAllMembers() {
        return null;
    }

    @Override
    public int registerMember(MemberDO member) {
        return memberDao.insertMember(member);
    }

    @Override
    public int updateMember(MemberDO member) {
        return 0;
    }

    @Override
    public int deleteMember(Integer memberId) {
        return memberDao.deleteMember(memberId);
    }


}
