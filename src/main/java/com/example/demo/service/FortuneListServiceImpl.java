package com.example.demo.service;

import com.example.demo.entity.Fortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fortuneService")
public class FortuneListServiceImpl implements FortuneListService {

    @Autowired
    private FortuneRepository repo;

    @Override
    public List<Fortune> getFortuneList() throws Exception {
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new Exception("Failed to retrieve fortune list.", e);
        }
    }
}
