package com.example.demo.dao;

import com.example.demo.domain.FortuneDO;
import com.example.demo.domain.MemberDO;
import com.example.demo.domain.NotifyDO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface MemberDao {

    MemberDO getMember(String email);
    NotifyDO getNotify();
    FortuneDO getFortune();

    MemberDO getMemberDO(Integer memberId);

    FortuneDO getFortune(String fortuneId);

    NotifyDO getNotify(String notifyId);
    int insertNotify(NotifyDO notifyId);
    int deleteNotify(String notifyId);

    int insertFortune(FortuneDO fortuneId);
    int deleteFortune(String fortuneId);

    int insertMember(MemberDO member);

    int deleteMember(Integer memberId);
}
