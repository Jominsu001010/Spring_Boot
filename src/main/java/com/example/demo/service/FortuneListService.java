package com.example.demo.service;

import com.example.demo.entity.Fortune;

import java.util.List;

public interface FortuneListService {
    List<Fortune> getFortuneList() throws Exception;
}