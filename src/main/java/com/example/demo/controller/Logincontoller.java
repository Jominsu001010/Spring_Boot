package com.example.demo.controller;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.MemberDaoImpl;
import com.example.demo.domain.LoginDO;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/Member")
public class Logincontoller {
    Gson gson = new Gson();
    @PostMapping("/login")
    public String login(@RequestBody LoginDO loginDO){

         MemberDao memberDao = new MemberDaoImpl();

        return memberDao.getMember("sjsj@naver.com").getName();
    }
}
