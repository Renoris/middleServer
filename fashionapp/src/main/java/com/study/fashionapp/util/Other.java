package com.study.fashionapp.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Other {
    private String urlStr;

    public Other(String url){
        this.urlStr=url;
    }

    public String sendJSON(byte[] data) throws IOException, IOException {
        String inputLine=null;
        StringBuffer stringBuffer=new StringBuffer();

        URL url=new URL(urlStr); //URL객체 생성

        HttpURLConnection conn=(HttpURLConnection)url.openConnection(); //url주소를 가지고 Http 커넥션 객체 생성
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "multipart/form-data");
        conn.setRequestProperty("Accept-Charset", "UTF-8");
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(10000);

        //데이터 전송
//        BufferedWriter bWriter=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//        bWriter.write(jObject.toString());\

        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(conn.getOutputStream());
        bufferedOutputStream.write(data);
        //전송된 결과를 읽어옴
        BufferedReader bReader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        while((inputLine=bReader.readLine())!=null){
            stringBuffer.append(inputLine);
        }
        bufferedOutputStream.close();
        bReader.close();
        conn.disconnect();

        return stringBuffer.toString();
    }

    public void post(String requestURL, File file) {

        try {
            HttpClient client = HttpClientBuilder.create().build(); // HttpClient 생성
            HttpPost postRequest = new HttpPost(requestURL); //POST 메소드 URL 새성
            postRequest.setHeader("Accept", "application/json");
            postRequest.setHeader("Connection", "keep-alive");
            postRequest.setHeader("Content-Type", "application/json");
            postRequest.setEntity(new FileEntity(file));

            HttpResponse response = client.execute(postRequest);

            //Response 출력
            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);
                System.out.println(body);
            } else {
                System.out.println("response is error : " + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e){
            System.err.println(e.toString());
        }
    }


}
