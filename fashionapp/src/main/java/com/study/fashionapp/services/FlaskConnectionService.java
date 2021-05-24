package com.study.fashionapp.services;

import com.study.fashionapp.data.Cloth;
import com.study.fashionapp.data.TagVector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public interface FlaskConnectionService {
    public JSONObject firstContact(MultipartFile multipartFile) throws Exception;
    public JSONObject secondContact(ArrayList<TagVector> list) throws Exception;
}
