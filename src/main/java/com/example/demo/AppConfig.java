package com.example.demo;

import com.example.demo.dao.MemberDao;
import com.example.demo.dao.MemberDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberDao memberDao() {
        return new MemberDaoImpl();
    }

    // 다른 빈들에 관한 설정
}