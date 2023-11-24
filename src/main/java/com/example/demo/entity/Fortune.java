package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORTUNE")
@Data
public class Fortune {
    @Id
    @Column(name = "FORTUNE_ID", length = 30)
    private String fortune_id;
    @Column(name = "FORTUNE_VARIETY", length = 50)
    private String fortune_variety;
    @Column(name = "FORTUNE_CONTENT", length = 1000)
    private String fortune_content;
    @Column(name = "FORTUNE_DATE", length = 6)
    private String fortune_date;
    @Column(name = "FORTUNE_STATE", length = 50)
    private String fortune_state;
    @Column(name = "MEMBER_ID", length = 5)
    private Integer member_id;
}
