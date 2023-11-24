package com.example.demo.service;

import com.example.demo.domain.FortuneDO;

import java.util.List;

public interface FortuneService {
    FortuneDO getFortune(String fortuneId);

    int registerFortune(FortuneDO fortune);

    int updateFortune(FortuneDO fortune);

    int deleteFortune(String fortuneId);

    List<FortuneDO> getFortune();
}
