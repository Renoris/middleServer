package study.bj.user.controller;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import study.bj.user.dao.UserDao;
import study.bj.user.data.PictureData;
import study.bj.user.data.User;
import study.bj.user.services.FileUploadService;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
    ArrayList goFirst(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException {
        //이미지 저장
        String saveFolder="C:\\test\\";
        fileUploadService.MultipartFileUpload(saveFolder,file);
        
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
                .ImageName(file.getOriginalFilename())
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
