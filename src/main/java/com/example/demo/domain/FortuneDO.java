package com.example.demo.domain;

public class FortuneDO {
    private String fortune_id;
    private String fortune_variety;
    private String fortune_content;
    private String fortune_date;
    private String fortune_state;
    private Integer member_id;

    public String getFortune_id() {
        return fortune_id;
    }

    public void setFortune_id(String fortune_id) {
        this.fortune_id = fortune_id;
    }

    public String getFortune_variety() {
        return fortune_variety;
    }

    public void setFortune_variety(String fortune_variety) {
        this.fortune_variety = fortune_variety;
    }

    public String getFortune_content() {
        return fortune_content;
    }

    public void setFortune_content(String fortune_content) {
        this.fortune_content = fortune_content;
    }

    public String getFortune_date() {
        return fortune_date;
    }

    public void setFortune_date(String fortune_date) {
        this.fortune_date = fortune_date;
    }

    public String getFortune_state() {
        return fortune_state;
    }

    public void setFortune_state(String fortune_state) {
        this.fortune_state = fortune_state;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }
}
