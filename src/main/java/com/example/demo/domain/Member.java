package com.example.demo.domain;

public class Member {
    private String id;
    private String pwd;
    private String name;
    private String phone;
    private String gender;
    private String birday;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirday() {
        return birday;
    }

    public void setBirday(String birday) {
        this.birday = birday;
    }
}
