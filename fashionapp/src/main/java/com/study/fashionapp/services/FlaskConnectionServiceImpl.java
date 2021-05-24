package com.study.fashionapp.services;

import com.study.fashionapp.data.Cloth;
import com.study.fashionapp.data.IdVector;
import com.study.fashionapp.data.TagVector;
import com.study.fashionapp.util.PostData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class FlaskConnectionServiceImpl implements FlaskConnectionService{
    private final String flaskFirstPath;
    private final String flaskSecondPath;
    private ClothService clothService;
    private JSONParser parser;

    @Autowired
    public FlaskConnectionServiceImpl(String flaskFirstPath, String flaskSecondPath, ClothService clothService){
        this.flaskFirstPath=flaskFirstPath;
        this.flaskSecondPath=flaskSecondPath;
        this.clothService=clothService;
        this.parser=new JSONParser();
    }

    public JSONObject firstContact(File file) throws Exception {
        PostData postData=new PostData(flaskFirstPath);
        postData.addParam("file",file); //네임 알아내야함-file맞다고함
        String result=postData.submit();
        return (JSONObject) parser.parse(result);
    }

    public JSONObject secondContact(ArrayList<TagVector> list) throws Exception{
        PostData postData=new PostData(flaskSecondPath);
        JSONObject map=new JSONObject();
        JSONObject lastObject=new JSONObject();

        map.put("item",convert(list));
//      //
//        return map;
        //
        postData.addParam(map);
        String result=postData.submit();
        JSONObject jsonObject=(JSONObject) parser.parse(result);
        JSONArray array=(JSONArray)jsonObject.get("item");
        ArrayList<Integer> idList=new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject object=(JSONObject) array.get(i);
            idList.add(Integer.parseInt(object.get("id").toString()));
        }
        ArrayList<Cloth> clothList=clothService.findAllId(idList);
        lastObject.put("list",clothList);
        return lastObject;
    }

    private List<HashMap<String,Object>> convert(ArrayList<TagVector> list){
        //만들기
        List<HashMap<String,Object>> item=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ArrayList<IdVector> idVectors= new ArrayList<>();
            HashMap<String,Object> map=new HashMap<>();

            map.put("original",list.get(i).getVector());
            map.put("tag",list.get(i).getTag());
            List<Cloth> clothList=clothService.findTag(list.get(i).getTag());
            for (int j = 0; j < clothList.size(); j++) {
                IdVector idVector=IdVector.builder()
                        .id(String.valueOf(clothList.get(j).getId()))
                        .vector(clothList.get(j).getVector())
                        .build();
                idVectors.add(idVector);
            }
            map.put("list",idVectors);
            item.add(map);
        }
        return item;
    }


    private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File file=new File(multipart.getOriginalFilename());
        multipart.transferTo(file);
        return file;
    }
}
