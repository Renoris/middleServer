package com.study.fashionapp.controller;

import com.study.fashionapp.data.ClothingDataFirst;
import com.study.fashionapp.services.ApiConnectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MiddleServerController {

    @Autowired
    ApiConnectionServiceImpl apiService;

    @PostMapping("/main")
    public @ResponseBody ClothingDataFirst main (@ModelAttribute MultipartFile multipartFile){
        if(multipartFile==null) {
            return null;
        }

    }




}
