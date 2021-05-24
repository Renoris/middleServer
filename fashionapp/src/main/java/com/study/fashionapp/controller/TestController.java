package com.study.fashionapp.controller;


import com.study.fashionapp.data.etc.TestData;
import com.study.fashionapp.services.ClothService;
import com.study.fashionapp.services.FlaskConnectionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class
TestController {
    FlaskConnectionServiceImpl flaskConnectionService;
    ClothService clothService;

    @Autowired
    public TestController(ClothService clothService, FlaskConnectionServiceImpl flaskConnectionService){
        this.flaskConnectionService=flaskConnectionService;
        this.clothService=clothService;
    }
    @GetMapping("/test")
    public @ResponseBody TestData serverTesting(){
        TestData testData=new TestData();
        testData.setMessage("서버가 연결된걸 확인하였습니다.");
        return testData;
    }
}
