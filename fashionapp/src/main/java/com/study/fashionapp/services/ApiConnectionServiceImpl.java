package com.study.fashionapp.services;

import com.study.fashionapp.data.PostData;
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
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

public class ApiConnectionServiceImpl  {
    @Autowired
    String flaskPath;

    MultipartEntityBuilder params;

    public void getPostData(PostData postData){
        this.params=postData.getEntityBuilder();
    }


    public String submit() throws Exception{
        CloseableHttpClient http = HttpClients.createDefault();
        StringBuffer result = new StringBuffer();

        try{
            HttpPost post = new HttpPost(flaskPath);
            post.setEntity(params.build());

            CloseableHttpResponse response = http.execute(post);

            try{
                HttpEntity res = response.getEntity();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(res.getContent(), Charset.forName("UTF-8")));

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
        JSONObject jsonObject=new JSONObject();
    }
}