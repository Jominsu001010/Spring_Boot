package com.example.demo.service;

import com.example.demo.domain.MemberDO;
import com.example.demo.domain.NotifyDO;
import com.example.demo.domain.FortuneDO;

import java.util.List;

public interface MemberService {
    MemberDO getMember(Integer memberId);

    List<MemberDO> getAllMembers();

    int registerMember(MemberDO member);

    int updateMember(MemberDO member);

    int deleteMember(Integer memberId);
}
