package com.study.fashionapp;

import com.study.fashionapp.controller.UserController;
import com.study.fashionapp.dao.ClothDao;
import com.study.fashionapp.dao.etc.LargeCategoryDao;
import com.study.fashionapp.data.Cloth;
import com.study.fashionapp.data.etc.LargeCategory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

@SpringBootTest
class FashionappApplicationTests {

    @Autowired
    ClothDao clothDao;

    @Autowired
    private LargeCategoryDao largeCategoryDao;

    @Autowired
    UserController userController;

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    void test1() throws Exception{
        LargeCategory largeCategory1=LargeCategory.builder().large("가방").build();
        LargeCategory largeCategory2=LargeCategory.builder().large("모자").build();
        LargeCategory largeCategory3=LargeCategory.builder().large("상의").build();
        LargeCategory largeCategory4=LargeCategory.builder().large("악세서리").build();
        LargeCategory largeCategory5=LargeCategory.builder().large("하의").build();
        LargeCategory largeCategory6=LargeCategory.builder().large("한벌옷").build();
        largeCategoryDao.save(largeCategory1);
        largeCategoryDao.save(largeCategory2);
        largeCategoryDao.save(largeCategory3);
        largeCategoryDao.save(largeCategory4);
        largeCategoryDao.save(largeCategory5);
        largeCategoryDao.save(largeCategory6);
    }


    @Test
    void test2() throws Exception {
        JSONObject jsonObject;
        JSONParser jsonParser;
        try {
            jsonParser=new JSONParser();
            FileInputStream fileInputStream = new FileInputStream(new File("F:\\Desktop\\original.json"));

            byte[] readbuffer = new byte[fileInputStream.available()];
            while (fileInputStream.read(readbuffer) != -1) {
            }
            String str = new String(readbuffer);
            jsonObject=(JSONObject) jsonParser.parse(str);
            System.out.println(jsonObject);
            Iterator firstKeyI=jsonObject.keySet().iterator();//첫번째 키 리스트 도출
            while (firstKeyI.hasNext()){//키리스트가 없어질때까지 반복
                String largeCategoryKey= firstKeyI.next().toString(); //키 도출
                JSONObject smallCategory=(JSONObject) jsonObject.get(largeCategoryKey); //키로 뽑아오기

                Iterator secondKeyI=smallCategory.keySet().iterator();
                while (secondKeyI.hasNext()){
                    String smallCategoryKey= secondKeyI.next().toString(); //키 도출
                    System.out.println("smallcategoryKey:"+smallCategoryKey);
                    JSONArray itemArray=(JSONArray) smallCategory.get(smallCategoryKey);
                    System.out.println();
                    for (int i = 0; i < itemArray.size(); i++) {
                        JSONObject item=(JSONObject) itemArray.get(i);
                        Cloth cloth=Cloth.builder()
                                .largecategory(largeCategoryKey)
                                .smallcategory(smallCategoryKey)
                                .title(item.get("tatle").toString())
                                .price(item.get("price").toString())
                                .link(item.get("link").toString())
                                .imagelink(item.get("image_link").toString())
                                .vector(item.get("vector").toString())
                                .build();
                        System.out.println("입력:"+cloth.toString());
                        clothDao.save(cloth);
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
