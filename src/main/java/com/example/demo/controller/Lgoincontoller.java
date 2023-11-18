package com.example.demo.controller;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="Member")
public class Lgoincontoller {
    @GetMapping()
    public Member login(){
        return new Member(0, "jominsu");

    }
    @GetMapping("args")
    public Member getArgs(
            @RequestParam(value = "id")String id,
            @RequestParam(value = "password")String password) {
        Member member = new Member(9999, id);
        member.setMsg(member.getMsg() + ", " + password);

        return member;
    }
}
