package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.domain.FortuneDO;

import java.util.List;

@Service
public class FortuneServiceImpl implements FortuneService {

    private MemberDao memberDao;

    @Autowired
    public FortuneServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }


    @Override
    public FortuneDO getFortune(String fortuneId) {
        return memberDao.getFortune(fortuneId);
    }

    @Override
    public int registerFortune(FortuneDO fortune) {
        return memberDao.insertFortune(fortune);
    }

    @Override
    public int updateFortune(FortuneDO fortune) {
        return 0;
    }

    @Override
    public int deleteFortune(String fortuneId) {
        return memberDao.deleteFortune(fortuneId);
    }

    @Override
    public List<FortuneDO> getFortune() {
        return null;
    }

}
