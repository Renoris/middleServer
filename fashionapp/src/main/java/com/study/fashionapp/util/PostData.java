package com.study.fashionapp.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class PostData {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private MultipartEntityBuilder params;
    private String url;

    public PostData(String url){
        this.url=url;
        this.params=MultipartEntityBuilder.create();

    }


    public PostData addParam(Map<String, Object> param){
        return addParam(param, DEFAULT_ENCODING);
    }

    /**
     * Map 으로 한꺼번에 파라메터 훅 추가하는 메소드
     * @param param 파라메터들이 담긴 맵
     * @param encoding 파라메터 encoding charset
     * @return
     */
    public PostData addParam(Map<String, Object> param, String encoding){
        for( Map.Entry<String, Object> e : param.entrySet() ){
            if (e.getValue() instanceof File) {
                addParam(e.getKey(), (File)e.getValue(), encoding);
            }else{
                addParam(e.getKey(), (String)e.getValue(), encoding);
            }
        }
        return this;
    }

    /**
     * 문자열 파라메터를 추가한다.
     * @param name 추가할 파라메터 이름
     * @param value 파라메터 값
     * @return
     */
    public PostData addParam(String name, String value){
        return addParam(name, value, DEFAULT_ENCODING);
    }

    public PostData addParam(String name, String value, String encoding){
        params.addPart(name, new StringBody(value, ContentType.create("text/plain", encoding)));

        return this;
    }

    /**
     * 업로드할 파일 파라메터를 추가한다.
     * @param name
     * @param file
     * @return
     */
    public PostData addParam(String name, File file){
        return addParam(name, file, DEFAULT_ENCODING);
    }

    public PostData addParam(String name, File file, String encoding){
        if( file.exists() ){
            try{
                params.addPart(name, new FileBody(file, ContentType.MULTIPART_FORM_DATA,
                                URLEncoder.encode(file.getName(), encoding)));
            }catch( Exception ex ){ ex.printStackTrace(); }

        }
        return this;
    }

    public MultipartEntityBuilder getEntityBuilder(){
        return this.params;
    }

    public String submit() throws Exception{
        CloseableHttpClient http = HttpClients.createDefault();
        StringBuilder result= new StringBuilder();

        try{
            HttpPost post = new HttpPost(url);
            post.setEntity(params.build());

            CloseableHttpResponse response = http.execute(post);

            try{
                HttpEntity res = response.getEntity();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(res.getContent(), StandardCharsets.UTF_8));

                String buffer = null;
                while( (buffer=br.readLine())!=null ){
                    result.append(buffer).append("\r\n");
                }
            }finally{
                response.close();
            }
        }finally{
            http.close();
        }
        return result.toString();
    }
}
