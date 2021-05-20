package com.study.fashionapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.study.fashionapp.dao.UserDao;
import com.study.fashionapp.data.PictureData;
import com.study.fashionapp.data.User;
import com.study.fashionapp.services.FileUploadService;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @Autowired
    FileUploadService fileUploadService;

    @GetMapping("/user/{id}")
    public User get(@PathVariable("id") Integer id){
        return userDao.findById(id).get();
    }

    @PostMapping("/picture")
    public @ResponseBody
    ArrayList goFirst(@ModelAttribute MultipartFile file, HttpServletRequest request) throws IOException {
        //이미지 저장
        if(file==null){
            return null;
        }
        fileUploadService.MultipartFileUpload(file);

//        //헤더작성
//        HttpHeaders headers=new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        //바디작성
//        MultiValueMap<String, Object> body=new LinkedMultiValueMap<>();
//        body.add("file",file);
//
//        //플라스크 url
//        String baseUri="주소!";
//
//        //헤더+바디를 보낼 인스턴스 생성
//        RestTemplate restTemplate=new RestTemplate();
//        HttpEntity<MultiValueMap<String, Object>> requestEntity =new HttpEntity<>(body,headers);
//
//        //보내기
//        ResponseEntity<PictureData> response=restTemplate.postForEntity(baseUri,requestEntity, PictureData.class);
//
//
//
        //보내줄 데이터를 담을 리스트 생성
        ArrayList<PictureData> list=new ArrayList<>();


        //데이터생성
        PictureData pc= PictureData.builder()
                .id(1)
                .image(file.getOriginalFilename())
                .Logo("test")
                .Price(13214)
                .ProductName("진팬츠")
                .ShoppingMall("asdmart")
                .Tag("바지")
                .build();
        list.add(pc);
        return list;
    }

}
