package com.example.demo.domain;

public class NotifyDO {
    private String notify_id;
    private String notify_title;
    private String notify_content;
    private String notify_regdate;
    private Integer member_id;

    public String getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getNotify_title() {
        return notify_title;
    }

    public void setNotify_title(String notify_title) {
        this.notify_title = notify_title;
    }

    public String getNotify_content() {
        return notify_content;
    }

    public void setNotify_content(String notify_content) {
        this.notify_content = notify_content;
    }

    public String getNotify_regdate() {
        return notify_regdate;
    }

    public void setNotify_regdate(String notify_regdate) {
        this.notify_regdate = notify_regdate;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    @Override
    public String toString() {
        return "NotifyDO{" +
                "notify_id='" + notify_id + '\'' +
                ", notify_title='" + notify_title + '\'' +
                ", notify_content='" + notify_content + '\'' +
                ", notify_regdate='" + notify_regdate + '\'' +
                ", member_id='" + member_id + '\'' +
                '}';
    }
}
