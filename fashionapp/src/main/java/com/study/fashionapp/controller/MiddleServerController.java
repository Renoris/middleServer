package com.study.fashionapp.controller;

import com.study.fashionapp.data.Cloth;
import com.study.fashionapp.services.FileUploadService;
import com.study.fashionapp.services.FlaskConnectionServiceImpl;
import com.study.fashionapp.services.ClothService;
import com.study.fashionapp.util.ApiFormConverter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

@RestController
public class MiddleServerController {
    FlaskConnectionServiceImpl flaskConnectionService;
    ClothService clothService;
    FileUploadService fileUploadService;
    String clientImagePath;

    @Autowired
    public MiddleServerController(ClothService clothService, FlaskConnectionServiceImpl flaskConnectionService , FileUploadService fileUploadService, String clientImagePath){
        this.flaskConnectionService=flaskConnectionService;
        this.clothService=clothService;
        this.fileUploadService=fileUploadService;
        this.clientImagePath=clientImagePath;
    }

    @PostMapping("/main")
    public @ResponseBody JSONObject main (@RequestParam("file") MultipartFile multipartFile) throws IOException {
        JSONObject result=new JSONObject();
        if(multipartFile==null) {
            System.out.println("멀티파트파일이 오지않았습니다");
            result.put("message","멀티파트파일이 오지않았습니다");
            return result;
        }else{
            try{
                fileUploadService.MultipartFileUpload(multipartFile, clientImagePath);
                JSONObject jsonObject=flaskConnectionService.firstContact(multipartFile);
                if(jsonObject==null){
                    System.out.println("첫번째 플라스크 통신 실패");
                    result.put("message","첫번째 플라스크 통신 실패");
                    return result;
                }




//                JSONArray jsonArray=(JSONArray)jsonObject.get("list");
//                jsonObject=flaskConnectionService.secondContact(new ApiFormConverter().convertArraylistTagVector(jsonArray));
//                if(jsonObject==null){
//                    System.out.println("두번째 플라스크 통신 실패");
//                    result.put("message","두번째 플라스크 통신 실패");
//                    return result;
//                }
                return jsonObject;
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("어디선가 에러가 났습니다");
                result.put("message","어디선가 에러가 났습니다");
                return result;
            }
        }
    }




}
