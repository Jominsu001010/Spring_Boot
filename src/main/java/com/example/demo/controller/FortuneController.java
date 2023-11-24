package com.example.demo.controller;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.MemberDaoImpl;
import com.example.demo.domain.LoginDO;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/")
public class FortuneController {

    @PostMapping("/fortune")
    public String fortune(@RequestBody LoginDO loginDO){

        MemberDao memberDao = new MemberDaoImpl();

        return memberDao.getMember("sjsj@naver.com").getName();
    }
}
