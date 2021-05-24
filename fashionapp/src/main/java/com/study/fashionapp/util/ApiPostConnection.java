package com.study.fashionapp.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ApiPostConnection {
    String path;

    public ApiPostConnection(String path){
        this.path=path;
    }

    public JSONObject submit(PostData postData) throws Exception{
        MultipartEntityBuilder params=postData.getEntityBuilder();
        if(params==null){
            System.out.println("params가 null입니다");
        }
        CloseableHttpClient http = HttpClients.createDefault();
        StringBuilder result = new StringBuilder();

        try{
            HttpPost post = new HttpPost(path);
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
        JSONParser parser=new JSONParser();
        return (JSONObject) parser.parse(result.toString());
    }
}