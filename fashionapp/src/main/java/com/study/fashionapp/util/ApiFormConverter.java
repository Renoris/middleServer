package com.study.fashionapp.util;


import com.study.fashionapp.data.TagVector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class ApiFormConverter {

    public ArrayList<TagVector> convertArraylistTagVector(JSONArray jsonArray) {
        ArrayList<TagVector> arrayList=new ArrayList<>();
        TagVector tagVector;
        for (int i = 0; i < jsonArray.size(); i++) {
            tagVector =new TagVector();
            JSONObject jsonObject=(JSONObject) jsonArray.get(i);
            tagVector.setTag(jsonObject.get("tag").toString());
            tagVector.setVector(jsonObject.get("vector").toString());
            arrayList.add(tagVector);
        }
        return arrayList;
    }

}
