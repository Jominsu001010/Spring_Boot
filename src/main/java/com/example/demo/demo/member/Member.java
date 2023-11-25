package com.example.demo.demo.member;


import com.example.demo.demo.member.dto.SignRequest;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tmp_seq")
    @SequenceGenerator(name = "tmp_seq", sequenceName = "tmp_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String email;

    private String pwd;

    private String name;

    private String gender;

    private String birthday;

    private String phone;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private List<Authority> roles = new ArrayList<>();

    public  void setRoles(List<Authority> role){
        this.roles = role;
        role.forEach(o -> o.setMember(this));
    }

}
