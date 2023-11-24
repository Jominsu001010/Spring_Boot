package com.example.demo.demo.member;


import com.example.demo.demo.member.dto.SignRequest;
import com.example.demo.demo.member.dto.SignResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignController {

    private final MemberRepository memberRepository;
    private final SignService memberService;

    @PostMapping(value = "/login")
    public ResponseEntity<SignResponse> signin(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(memberService.login(request), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Boolean> signup(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(memberService.register(request), HttpStatus.OK);
    }

    @GetMapping("/user/get")
    public ResponseEntity<SignResponse> getUser(@RequestParam String email) throws Exception {
        return new ResponseEntity<>( memberService.getMember(email), HttpStatus.OK);
    }

    @GetMapping("/admin/get")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String email) throws Exception {
        return new ResponseEntity<>( memberService.getMember(email), HttpStatus.OK);
    }
    @PostMapping("/user/update")
    public ResponseEntity<Boolean> updateMyInfo(@RequestBody SignRequest request) throws Exception{
        return new ResponseEntity<>(memberService.updateMember(request), HttpStatus.OK);
    }
}