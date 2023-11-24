package com.example.demo.demo.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tmp_seq")
    @SequenceGenerator(name = "tmp_seq", sequenceName = "tmp_seq", allocationSize = 1)
    private Long id;

    private String name;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private   Member member;
    public void setMember(Member member){
        this.member = member;
    }
}
