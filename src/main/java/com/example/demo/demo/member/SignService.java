package com.example.demo.demo.member;


import com.example.demo.demo.member.dto.SignRequest;
import com.example.demo.demo.member.dto.SignResponse;
import com.example.demo.demo.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignResponse login(SignRequest request) throws Exception {
        Member member = memberRepository.findByEmail(request.getEmail()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        if (!passwordEncoder.matches(request.getPwd(), member.getPwd())) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return SignResponse.builder()
                .token(jwtProvider.createToken(member.getEmail(), member.getRoles()))
                .build();

    }
    public boolean register(SignRequest request) throws Exception {
        try {
            Member member = Member.builder()
                    .email(request.getEmail())
                    .pwd(passwordEncoder.encode(request.getPwd()))
                    .name(request.getName())
                    .gender(request.getGender())
                    .birthday(request.getBirthday())
                    .phone(request.getPhone())
                    .build();

            member.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));

            memberRepository.save(member);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public SignResponse getMember(String email) throws Exception {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new SignResponse(member);
    }


    public boolean updateMember(SignRequest request) throws Exception {
        try {
            // 기존 회원 정보 조회
            Member member = memberRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));

            // 업데이트할 정보 설정
            member.setPwd(passwordEncoder.encode(request.getPwd()));
            member.setName(request.getName());
            member.setGender(request.getGender());
            member.setBirthday(request.getBirthday());
            member.setPhone(request.getPhone());

            // 회원 정보 업데이트
            memberRepository.save(member);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("회원 정보 업데이트에 실패했습니다.");
        }
        return true;
    }

}
