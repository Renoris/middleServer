package com.study.fashionapp.services.etc;

import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.study.fashionapp.data.PictureData;

import java.nio.charset.StandardCharsets;

public class etcService {
    public void normalRestApi(){
        //플라스크로 보내는 작업1 - uri 설정
        String baseUrl="주소";
        UriComponents uriComponents= UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("키","키값").build();

        //플라스크로 보내는 작업2 - 헤더 작성
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(new MediaType("multipart","formed-data", StandardCharsets.UTF_8));

        //플라스크로 보내는 작업3 - 타임아웃 설정을 위한 객체 만들기
        HttpComponentsClientHttpRequestFactory factory=new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);

        //플라스크로 보내는 작업4 - 위의 3가지를 실행시켜줄 template 객체 만들기
        RestTemplate template=new RestTemplate(factory);

        //결과받기
        ResponseEntity<PictureData> response = template.exchange(uriComponents.toString(), HttpMethod.GET, new HttpEntity<String>(headers), PictureData.class);

    }
}
