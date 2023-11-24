package com.example.demo.demo.member.dto;


import com.example.demo.demo.member.Authority;
import com.example.demo.demo.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {
    private Long id;
    private String email;
    private String name;
    private String gender;
    private String birthday;
    private String phone;
    private List<Authority> roles = new ArrayList<>();
    private String token;

    public SignResponse (Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.gender = member.getGender();
        this.birthday = member.getBirthday();
        this.phone = member.getPhone();
        this.roles = member.getRoles();
    }


}
