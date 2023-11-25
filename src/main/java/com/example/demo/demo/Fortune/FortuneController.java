package com.example.demo.demo.Fortune;

import com.example.demo.entity.Fortune;
import com.example.demo.service.FortuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fortunes")
public class FortuneController {

    @Autowired
    private FortuneRepository fortuneRepository;

    // 운세 조회
    @PostMapping("/retrieve")
    public ResponseEntity<Map<String, Object>> retrieveFortune(@RequestBody Map<String, String> request) {
        String type = request.get("type");
        List<Fortune> fortuneList = fortuneRepository.findByType(type);

        Map<String, Object> response = new HashMap<>();
        response.put("fortune_list", fortuneList);
        response.put("rslt_code", "0000");
        response.put("rslt_msg", "정상적으로 조회되었습니다.");

        return ResponseEntity.ok(response);
    }

    // 운세 저장
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> saveFortune(@RequestBody Fortune fortuneRequest) {
        // 운세 저장 로직 수행
        Fortune savedFortune = fortuneRepository.save(fortuneRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("rslt_code", "0000");
        response.put("rslt_msg", "정상적으로 저장되었습니다.");

        return ResponseEntity.ok(response);
    }
}