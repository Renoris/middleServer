package com.study.fashionapp.controller;


import com.study.fashionapp.data.etc.TestData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    public @ResponseBody TestData serverTesting(){
        TestData testData=new TestData();
        testData.setMessage("서버가 연결된걸 확인하였습니다.");
        return testData;
    }
}
