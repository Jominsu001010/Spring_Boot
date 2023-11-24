package com.example.demo.service;

import com.example.demo.entity.Fortune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FortuneRepository extends JpaRepository<Fortune, String> {
}
