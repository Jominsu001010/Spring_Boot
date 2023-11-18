package com.example.demo.controller;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.MemberDaoImpl;
import com.example.demo.domain.LoginDO;
import com.example.demo.domain.Member;
import com.example.demo.domain.resDO;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/Member")
public class Lgoincontoller {
    Gson gson = new Gson();
    @PostMapping("/login")
    public String login(@RequestBody LoginDO loginDO){

        MemberDao memberDao = new MemberDaoImpl();

        return memberDao.getMember().getId();
    }
}
