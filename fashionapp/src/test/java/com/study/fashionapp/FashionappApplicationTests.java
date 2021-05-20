package com.study.fashionapp;

import com.study.fashionapp.controller.UserController;
import com.study.fashionapp.dao.etc.LargeCategoryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class FashionappApplicationTests {

    @Autowired
    private LargeCategoryDao largeCategoryDao;

    @Autowired
    UserController userController;

    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }


    @Test
    void test1() throws Exception {
        FileInputStream fileInputStream=new FileInputStream(new File("F:\\Desktop\\medicine.png"));
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockMultipartFile multipartFile=new MockMultipartFile("file","medicine.png","multipart/form-data",fileInputStream);
        MvcResult result=mockMvc.perform(
                multipart("/picture")
                        .file(multipartFile))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

}
